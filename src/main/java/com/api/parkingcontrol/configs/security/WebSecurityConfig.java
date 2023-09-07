package com.api.parkingcontrol.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@SuppressWarnings("deprecation")
//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	final UserDetailsService userDetailsService;
	
	public WebSecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic() //Usa o tipo básico de autenticação
		.and() //Tem função de unir requisição
		.authorizeHttpRequests() //Autoriza as requisições
		.antMatchers(HttpMethod.GET, "/parking-spot/**").permitAll() //Permite que todos acessem sem precisar estar autenticado inclusive passando parametros (/**)
		.antMatchers(HttpMethod.POST, "/parking-spot").hasRole("USER") //Apenas user pode fazer post
		.antMatchers(HttpMethod.DELETE, "/parking-spot/**").hasRole("ADMIN") //Apenas admin pode deletar
		.anyRequest().authenticated() //Para usuários autenticados
		.and()//Usuário precisa de autenticação para acessar o endpoint
		.csrf().disable(); //Evita usuário malicioso enviar script quando habilitado utilizando um thymeleaf por exemplo, sem ser API Rest	
	}

	//Autenticação do usuário customizada
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
