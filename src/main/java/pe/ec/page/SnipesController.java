package pe.ec.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/snipes")
public class SnipesController {
	@RequestMapping("/")
	public String getGreeting() {
		return "Hello World!";
	}
}
