package pe.ec.util.web;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("pe.ec.util.web")
public class Util {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Util.class, args);
	}
}
