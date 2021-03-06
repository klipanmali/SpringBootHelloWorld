package my.springboot.hello.controller;

import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.springboot.hello.model.Product;
import my.springboot.hello.service.ProductService;

@RestController
@RefreshScope
@RequestMapping("/hello")
// If RESTFull app is on 8080 and Web app on 9090
// @CrossOrigin(origins = "http://localhost:9090")
public class HelloController {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloController.class);
	private static final java.util.logging.Logger sLogger = java.util.logging.Logger
			.getLogger(HelloController.class.getName());

	@Autowired
	ProductService productService;

	// assign value defined in spring.application.name if exist
	// or assign default name "demoservice"
	@Value("${spring.application.name:demoservice}")
	private String appName;

	@Value("${welcome.message:default welcome message}")
	private String welcomeMessage;

	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	// valid requests are :8080/hello :8080/hello/
	public String index() {
		// logger.debug("You have hit 'Greetings' page");
		// do I really need this to have zipkin logging, it doesn't work anyhow
		sLogger.log(Level.INFO, "You have hit 'Greetings' page");
		return welcomeMessage + "<br>" + "Greetings from " + appName
				+ " Spring Boot!";
	}

	// GET
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:9090")
	public ResponseEntity<Object> getProduct() {
		logger.info("GET: getting products");
		return new ResponseEntity<>(productService.getProducts(),
				HttpStatus.OK);
	}

	// POST
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		logger.info("POST: creating product");
		return new ResponseEntity<>(productService.createProduct(product),
				HttpStatus.CREATED);
	}

	// PUT
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id,
			@RequestBody Product product) {
		logger.info("PUT: updating product");
		return new ResponseEntity<>(productService.updateProduct(id, product),
				HttpStatus.OK);
	}

	// DELETE
	@RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
		logger.info("DELETE: deleting product");
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
	}

}