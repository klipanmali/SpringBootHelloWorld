package my.springboot.hello.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {

	private static final Logger logger = LoggerFactory
			.getLogger(HystrixController.class);

	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	// @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
	// @HystrixProperty(name =
	// "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
	// execution.isolation.thread.timeoutInMilliseconds default value is 1000
	@HystrixCommand(fallbackMethod = "fallback_hello")
	// !!!!!!!!!!!!!!!
	// any exceptions in this method will be hidden by Hystrix circuit breaker
	// !!!!!!!!!!!!!!!
	public String hystrixHello() throws InterruptedException {
		Random rnd = new Random();
		int sleepTime = rnd.nextInt(3000);
		logger.info(String.format("Going to sleep for %d sec", sleepTime));
		Thread.sleep(sleepTime);
		return "Welcome Hystrix";
	}

	// fallback method should be defined in same class and should have same the
	// same signature
	public String fallback_hello() {
		logger.info("Hystrix timeout");
		return "Hystrix request timeout";
	}
}
