package my.springboot.hello.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// it doesn't work , need been serverHttpSecurity
// @Configuration
// @EnableWebSecurity //do I need this ???
//public class ActuatorsSecurity {
//
//	@Bean
//	public SecurityWebFilterChain securityWebFilterChain(
//			ServerHttpSecurity http) {
//		return http.authorizeExchange().pathMatchers("/actuator/**").permitAll()
//				.anyExchange().authenticated().and().build();
//
//	}

@Configuration
public class ActuatorsSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().permitAll().and().csrf()
				.disable();
	}

}
