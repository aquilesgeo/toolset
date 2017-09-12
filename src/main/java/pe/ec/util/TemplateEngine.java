package pe.ec.util;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class TemplateEngine {
	private String template;
	private Map<String, Object> tokenMap = new HashMap<String, Object>();

	public final static TemplateEngine instance() {
		TemplateEngine engine = new TemplateEngine();
		return engine;
	}

	private TemplateEngine() {
		// Isolate constructor
	}

	public TemplateEngine v(String key, Object value) {
		this.tokenMap.put(key, value);
		return this;
	}

	public TemplateEngine template(String template) {
		this.template = template;
		return this;
	}

	public void generate(String fileName) throws Exception {

		PrintWriter writer = new PrintWriter(new File(fileName));

		processTemplate(writer);

		writer.flush();
		writer.close();
	}

	private void processTemplate(Writer writer) {
		VelocityEngine ve = new VelocityEngine();
		ve.init();
		Template t = ve.getTemplate(this.template);
		VelocityContext context = new VelocityContext();

		for (String key : this.tokenMap.keySet()) {
			context.put(key, this.tokenMap.get(key));
		}
		t.merge(context, writer);
	}

	public String generate() throws Exception {
		StringWriter writer = new StringWriter();
		processTemplate(writer);
		return writer.toString();
	}

}
