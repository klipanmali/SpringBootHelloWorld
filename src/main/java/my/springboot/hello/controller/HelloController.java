package my.springboot.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.springboot.hello.model.Product;
import my.springboot.hello.service.ProductService;

@RestController
@RequestMapping("/hello")
public class HelloController {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloController.class);

	@Autowired
	ProductService productService;

	// assign value defined in spring.application.name if exist
	// or assign default name "demoservice"
	@Value("${spring.application.name:demoservice}")
	private String appName;

	@RequestMapping(value = {"", "/"}) // valid requests are :8080/hello
										// :8080/hello/
	public String index() {
		logger.debug("You have hit 'Greetings' page");
		return "Greetings from " + appName + " Spring Boot!";
	}

	// GET
	@RequestMapping(value = "/products")
	public ResponseEntity<Object> getProduct() {
		return new ResponseEntity<>(productService.getProducts(),
				HttpStatus.OK);
	}

	// POST
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.createProduct(product),
				HttpStatus.CREATED);
	}

	// PUT
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id,
			@RequestBody Product product) {
		return new ResponseEntity<>(productService.updateProduct(id, product),
				HttpStatus.OK);
	}

	// DELETE
	@RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
	}

}