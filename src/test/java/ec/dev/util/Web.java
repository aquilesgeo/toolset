package ec.dev.util;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;

public class Web {
	public void pom(String group, String artifact) {
		Base.template("vm\\web\\pom.vm")
		.v("basePackage", Base.basePackage)
		.v("group", group)
		.v("artifact", artifact)
		.generate();
		Base.line();
	}
	public void springContext(String ... mappers) {
		Base.template("vm\\web\\spring-servlet.vm")
			.v("basePackage", Base.basePackage)
			.v("StringUtils", StringUtils.class)
			.v("mapperList", Arrays.asList(mappers))
			.generate();
		Base.line();
	}
	
	public void web(String app) {
		Base.template("vm\\web\\web.vm")
			.v("app", app)
			.generate();
		Base.line();
	}
	public void contentWeb(String app, String creditos) {

		Base.template("vm\\web\\jsp\\_headercontent.vm")
				.generate();
		Base.line();
		Base.template("vm\\web\\jsp\\index.vm")
			.v("app", app)
			.v("creditos", creditos)
			.generate();
		Base.line();
		Base.template("vm\\web\\jsp\\intro.vm")
				.generate();
		Base.line();
	}
}
