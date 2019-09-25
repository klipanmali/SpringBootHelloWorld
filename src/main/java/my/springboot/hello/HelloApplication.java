package my.springboot.hello;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

	// @Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println(
					"Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world from Command line runner");
		System.err.println("input arguments " + args.length + " : "
				+ Arrays.toString(args));
	}

}