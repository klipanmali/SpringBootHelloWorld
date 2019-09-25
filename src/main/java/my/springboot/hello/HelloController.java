package my.springboot.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloController.class);

	// assign value defined in spring.application.name if exist
	// or assign default name "demoservice"
	@Value("${spring.application.name:demoservice}")
	private String appName;

	@RequestMapping("/")
	public String index() {
		logger.debug("You have hit 'Greetings' page");
		return "Greetings from " + appName + " Spring Boot!";
	}

}