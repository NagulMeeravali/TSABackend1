package com.talentstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import com.talentstream.config.WebConfig;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


@SpringBootApplication
@EnableWebMvc
public class TalentStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentStreamApplication.class, args);
	}
	
	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.talentstream")) 
	                .paths(PathSelectors.any())
	                .build();
	        
	    }
	 
	/* public WebMvcConfigurer crossConfigurer() {
		 
		 return new WebMvcConfigurer() {
		  public void addCorsMappings(CorsRegistry registry) {
			  registry.addMapping("/**").allowedOrigins("https://tsa-nagulmeeravali.vercel.app/");
		  }
		 };
	 } */
	 
	 

}
