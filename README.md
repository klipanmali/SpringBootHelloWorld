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

Actuators: out of the box management services: 
    actuator/health - application health
    actuator/shutdown
    actuator/metrics - application metrics such as memory used, memory free, threads, classes, system uptime etc
    actuator/env -  list of Environment variables used in the application
    actuator/beans - Spring beans and its types, scopes and dependency
    actuator/info - information about the Spring Boot application

Command line runner and Application runner

Application properties
java -jar "jarfile".jar --server.port=23456
java -jar "jarfile".jar -Dspring.config.location=C:\path_to_external.properties
java -jar "jarfile".jar --spring.profiles.active="active profile"

Logging

Exception handling

Interceptors

Servlet filters

Tomcat Port Number

file upload/download

Services components

Thymeleaf - Java-based library used to create a web application.

Consuming RESTFull service by using jQuery AJAX

Cross-Origin Resource Sharing (CORS) Support

Internalization
 ( it doesnt xwork)
 
Scheduling

Enabling HTTPS

Eureka server/client

Zuul server

Spring config server


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
  - @ControlerAdvice - handles exceptions globally, annotated class is central place to implement exception handling for 
    every single exception(@ExceptionHandler)
  - @EnableAutoConfiguration - Spring Boot automatically configures your application based on the dependences you have added
  - @EnableEurekaServer - make your Spring Boot application acts as a Eureka Server
  - @EnableEurekaClient - makes your Spring Boot application act as a Eureka client.
  - @EnableZuulProxy - makes your Spring Boot application act as a Zuul Proxy server.
  - @EnableConfigServer - makes your Spring Boot application act as a Configuration Server.
  - @ExceptionHandler - handle the specific exception and sending the custom responses to the client
  - @Inject - for injecting, but @Autowired is little bit more powerful
  - @LocalServerPort - add local server port discovered at runtime
  - @PathVariable - define the custom or dynamic request URI. The Path variable in request URI is defined as curly braces {}
  - @Primary - in case of multiple beans, bean annotated with @Primary is injected
  - @Profile("profileName") - for which profile to start this bean
  - @Qualifier(qualifierName) - qualifies what bean to inject
  - @RefreshScope - load the configuration properties value from the Config Server,
    force a bean to refresh its configuration (that is, to pull updated values from the Config Server)
  - @RequestBody - define the request body content type.
  - @RequestMapping - request url mapping handled by controller. Used to define the Request URI to access the REST Endpoints.
  - @RequestParam - read the request parameters from the Request URL. By default, it is a required parameter. We can also set default value
    for request parameters
  - @Resource -for injecting, but @Autowired is little bit more powerful
  - @RestController - controller, controls the ULRs, combines @Controller and @ResponseBody, two annotations that results in
    web requests returning data rather than view(MVC). Used to define the RESTful web services. It serves JSON, XML and custom response.
  - @Service - Service Components, used to contain business logic
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
  - @Value("${property_key_name}" - read the environment or application property value in Java code. If the property is not found while 
    running the application, Spring Boot throws the Illegal Argument exception
  - @Value("${property_key_name:default_value}" - if property is not found, use default value
  - @WebMvcTest - create only the web layers of the context
