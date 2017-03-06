package pe.ec.db.entity;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import junit.framework.TestCase;

public class TemplateTest extends TestCase{
	public void testTemplate(){
		VelocityEngine ve = new VelocityEngine();
        ve.init();
        Template t = ve.getTemplate( "vm/db/hibernate-hbm-xml.vm" );
        VelocityContext context = new VelocityContext();
        
        context.put("name", "World");
        
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        /* show the World */
        System.out.println( writer.toString() );
	}
}
