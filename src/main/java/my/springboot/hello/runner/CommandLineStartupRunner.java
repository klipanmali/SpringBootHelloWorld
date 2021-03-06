package my.springboot.hello.runner;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineStartupRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory
			.getLogger(CommandLineStartupRunner.class);

	@Override
	public void run(String... args) throws Exception {
		logger.info("App started with " + args.length + " : "
				+ Arrays.toString(args));
	}

}
