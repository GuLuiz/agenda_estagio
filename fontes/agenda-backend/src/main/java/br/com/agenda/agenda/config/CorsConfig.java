package br.com.agenda.agenda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Aplique a configuração de CORS para os endpoints da API
                        .allowedOrigins("http://192.168.15.6:4200") // Permita solicitações de qualquer origem (substitua '*' pelo domínio apropriado)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permita todos os métodos HTTP
                        .allowedHeaders("*"); // Permita todos os cabeçalhos
                        
            }
        };
    }
}