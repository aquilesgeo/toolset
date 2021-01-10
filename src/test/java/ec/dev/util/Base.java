package ec.dev.util;

import org.apache.velocity.texen.util.FileUtil;

public class Base {
	protected static String basePath = "";
	protected static String basePackage = "";
	protected Web web;
	protected Data data;

	public Base(String basePath, String basePackage) {
		Base.basePath = basePath;
		Base.basePackage = basePackage;
		web = new Web();
		data = new Data();
	}

	public final static TemplateEngine template(String templateName) {
		return TemplateEngine.instance().template(templateName);
	}

	public void webTemplate() {
		FileUtil.mkdir(basePath + "\\src\\main\\java");
		FileUtil.mkdir(basePath + "\\src\\test\\java");
		FileUtil.mkdir(basePath + "\\src\\main\\resources");
		FileUtil.mkdir(basePath + "\\src\\main\\webapp\\WEB-INF");
		FileUtil.mkdir(basePath + "\\src\\main\\webapp\\WEB-INF\\jsp");
	}
	public final static void line() {
		System.out.println();
		System.out.println("____________________________________________________");
		System.out.println();
	}
	
	protected Column col(String column, String property){
		Column col = new Column();
		col.column = column;
		col.property = property;
		return col;
	}
}
