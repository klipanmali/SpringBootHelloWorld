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



Spring annotations:
  - @AutoConfigureMockMvc - sets up MockMvc from Spring Test which  allows, via a set of convenient builder classes, to send HTTP requests
    into the DispatcherServlet and make assertions about the result
  - @LocalServerPort - add local server port discovered at runtime
  - @SpringBootTest - whole application context to be created. An alternative would be to ask Spring Boot to create only the web layers
    of the context using the @WebMvcTest
  - @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) - start up embedded server on random port
  - @WebMvcTest - create only the web layers of the context
