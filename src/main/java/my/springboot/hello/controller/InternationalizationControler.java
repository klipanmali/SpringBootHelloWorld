package my.springboot.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InternationalizationControler {

	@RequestMapping("/locale")
	public String locale() {
		return "locale";
	}

}
