package pe.ec.db.entity;

import junit.framework.TestCase;
import pe.ec.util.TemplateEngine;

public class TemplateTest extends TestCase {
	public void testTemplate() throws Exception {
 
		TemplateEngine.instance()
			.v("name", "World")
			.template("vm/db/hibernate-hbm-xml.vm")
			.generate("data/template-data.txt");

	}
}
