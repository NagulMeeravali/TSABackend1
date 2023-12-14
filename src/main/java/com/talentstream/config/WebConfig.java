package com.talentstream.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 
import java.util.Arrays;
 
@Configuration
//@EnableWebMvc
public class WebConfig {
 
    private static final Long MAX_AGE = 3600L;
    private static final int CORS_FILTER_ORDER = -102;
 
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/public/images/**");
    }
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        //config.setAllowCredentials(true);

        //config.addAllowedOrigin("http://localhost:3000");
        //  config.addAllowedOrigin("https://talent-stream-front-end-version2-kwrsb2zt1-eedekarunakar.vercel.app");
          //  config.addAllowedOrigin("https://talent-stream-front-end-version2-eedekarunakar.vercel.app");
 config.addAllowedOrigin("https://talent-stream-lalitha12-web.vercel.app");
     
        config.setAllowedHeaders(Arrays.asList(
                HttpHeaders.AUTHORIZATION,
                HttpHeaders.CONTENT_TYPE,
                HttpHeaders.ACCEPT));
        config.setAllowedMethods(Arrays.asList(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.DELETE.name()));
        config.setMaxAge(MAX_AGE);
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
 
        // should be set order to -100 because we need to CorsFilter before SpringSecurityFilter
        bean.setOrder(CORS_FILTER_ORDER);
        return bean;
    }

}
 
