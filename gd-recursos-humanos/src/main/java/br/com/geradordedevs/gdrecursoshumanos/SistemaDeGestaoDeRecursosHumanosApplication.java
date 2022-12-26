package br.com.geradordedevs.gdrecursoshumanos;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SistemaDeGestaoDeRecursosHumanosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeGestaoDeRecursosHumanosApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return  new ModelMapper();
	}
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new  BCryptPasswordEncoder();
	}
}
