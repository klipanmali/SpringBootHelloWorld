# SpringBootHelloWorld

Spring Boot gradle version project

The Spring Boot gradle plugin provides many convenient features:

  - It collects all the jars on the classpath and builds a single, runnable "über-jar", which makes it more convenient to execute and
    transport your service.
	  
  - It searches for the public static void main() method to flag as a runnable class.
	
  - It provides a built-in dependency resolver that sets the version number to match Spring Boot dependencies. You can override any
    version you wish, but it will default to Boot’s chosen set of versions.
	  
Spring Boot maven version project

The Spring Boot Maven plugin provides many convenient features:

  - It collects all the jars on the classpath and builds a single, runnable "über-jar", which makes it more convenient to execute
    and transport your service.
	  
  - It searches for the public static void main() method to flag as a runnable class
	
  - It provides a built-in dependency resolver that sets the version number to match Spring Boot dependencies. You can override 
    any version you wish, but it will default to Boot’s chosen set of versions.

Actuators: out of the box management services: actuator/health, actuator/shutdown

Spring annotations:
  - @AutoConfigureMockMvc - sets up MockMvc from Spring Test which  allows, via a set of convenient builder classes, to send HTTP requests
    into the DispatcherServlet and make assertions about the result
  - @Autowired - inject annotated field
  - @Bean - annotated methods creates beans from third party classes, with default bean equal to the name of the annotated method
  - @Component (also called Beans) - components to inject
  - @Component("componentName") -if name is not provided , component name is the same as class name written in camel case
  - @ComponentScan - Spring Boot automatically scans all the components, beans and package declarations when the application initializes 
  - @Conditional - another way to include/exclude beans apart from @Profile, based on conditions you provide
  - @ConditionalOnClass
  - @ConditionalOnProperty
  - @ConditionalOnMissingBean
  - @Configuration - class annotated with this annotation is used to create beans from some third party classes
  - @EnableAutoConfiguration - Spring Boot automatically configures your application based on the dependences you have added
  - @Inject - for injecting, but @Autowired is little bit more powerful
  - @LocalServerPort - add local server port discovered at runtime
  - @Primary - in case of multiple beans, bean annotated with @Primary is injected
  - @Profile("profileName") - for which profile to start this bean
  - @Qualifier(qualifierName) - qualifies what bean to inject
  - @RequestMapping - request url mapping handled by controller
  - @Resource -for injecting, but @Autowired is little bit more powerful
  - @RestController - controller, controls the ULRs, combines @Controller and @ResponseBody, two annotations that results in
    web requests returning data rather than view(MVC)
  - @SpringBootApplication - the entry point for the spring boot application, package containing @SpringBootApplication class and all
    sub packages are scanned for classes to add in "Application context", combines:
    - @Configuration - tags the class as a source of bean definitions for the application context
    - @EnabeAutiConfiguration - tells Spring Boot to start adding beans based on classpath settings, other beans and
      various property settings
    - @ComponentScan - tells Spring to look for other components, configurations and services in the package, allowing it
      to find controllers
  - @SpringBootApplication(scanBasePackageClasses = {SomeClcass.class}) - package containing SomaClass.class and all the sub packages are
    scanned for classes to add in "Application context", you can specify a list of classes
  - @SpringBootTest - whole application context to be created. An alternative would be to ask Spring Boot to create only the web layers
    of the context using the @WebMvcTest
  - @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) - start up embedded server on random port
  - @WebMvcTest - create only the web layers of the context
