package ec.dev.util;

import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class TemplateEngine {

	private static TemplateEngine engine = null;
	private String template;
	private Map<String, Object> tokenMap = new HashMap<String, Object>();

	public final static TemplateEngine instance() {
		if (engine == null) {
			engine = new TemplateEngine();
		}
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

	public void generate(String fileName) {
		try {
			PrintWriter writer = new PrintWriter(new File(fileName));
			processTemplate(writer);

			writer.flush();
			writer.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void generate(PrintStream out) throws Exception {

		PrintWriter writer = new PrintWriter(out);
		processTemplate(writer);
		writer.flush();
	}

	public void generate() {
		try {
			PrintWriter writer = new PrintWriter(System.out);
			processTemplate(writer);
			writer.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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

}
