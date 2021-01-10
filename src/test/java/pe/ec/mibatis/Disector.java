package pe.ec.mibatis;

import org.junit.Test;

public class Disector extends Mapping{
	public Disector(){
		super("ec.dev.disector");
	}
	@Test
	public void generateProject() {
		table("project")			
		.alias("project")
		.entity("Project")
		.id("_id","id")
		.col("_name","name");
	}
	
	@Test
	public void generateContent() {
		
	}
}
