package my.springboot.hello.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CORS extends WebMvcConfigurerAdapter {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new CORS();
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/hello/products")
				.allowedOrigins("http://localhost:8080");
	}

}
