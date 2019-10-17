package my.springboot.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/index")
public class WebController {

	private static final Logger logger = LoggerFactory
			.getLogger(WebController.class);

	@RequestMapping(value = "")
	public String index() {
		logger.info("Accessing Web: index page");
		return "index";
	}

	@RequestMapping(value = "/view-products")
	public String viewProducts() {
		logger.info("Accessing Web: view-products");
		return "view-products";
	}

	@RequestMapping(value = "/add-products")
	public String addProducts() {
		logger.info("Accessing Web: add-products");
		return "add-products";
	}
}
