package com.api.parkingcontrol.configs.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic() //Usa o tipo básico de autenticação
		.and() //Tem função de unir requisição
		.authorizeHttpRequests() //Autoriza as requisições
		.anyRequest().permitAll(); //Para qualquer requisição ele permite tudo
	}
	
	

}
