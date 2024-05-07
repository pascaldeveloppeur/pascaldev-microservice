package org.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;

@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition
@Slf4j
public class MemberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
		log.info("Member service started!");
	}
//	@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable().authorizeHttpRequests(auth -> {
//            auth.requestMatchers("/v3/**", "/swagger-ui/**").permitAll();
//            auth.anyRequest().authenticated();
//        });
//
//return httpSecurity.build();
}
