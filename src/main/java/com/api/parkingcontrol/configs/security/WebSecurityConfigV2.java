package com.api.parkingcontrol.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfigV2 {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
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
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
