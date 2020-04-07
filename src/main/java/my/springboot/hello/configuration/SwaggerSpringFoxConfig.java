package my.springboot.hello.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerSpringFoxConfig {

	// https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
	// All controllers, Error controller ....
	// @Bean
	// public Docket api() {
	// return new Docket(DocumentationType.SWAGGER_2).select()
	// .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
	// .build();
	// }

	// only my controllers
	// https://www.tutorialspoint.com/spring_boot/spring_boot_enabling_swagger2.htm
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("my.springboot.hello.controller"))
				// exclude internationalization
				.paths(Predicates.not(PathSelectors.regex("/locale.*")))
				// exclude web
				.paths(Predicates.not(PathSelectors.regex("/index.*"))).build();
		// only Hello controller
		// .paths(PathSelectors.regex("/hello.*")).build();
	}

	// configuration without Spring Boot.
	// Swagger UI adds a set of resources which you must configure as part of a
	// class that extends
	// WebMvcConfigurerAdapter, and is annotated with @EnableWebMvc.
	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// registry.addResourceHandler("swagger-ui.html")
	// .addResourceLocations("classpath:/META-INF/resources/");
	//
	// registry.addResourceHandler("/webjars/**")
	// .addResourceLocations("classpath:/META-INF/resources/webjars/");
	// }

}
