package my.springboot.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory
			.getLogger(ApplicationStartupRunner.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Your Application has been started");
	}

}
