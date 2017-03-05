package pe.ec.db.entity;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Model {
	private String name;
	private String baseDomain;
	private String baseHbm;
	private String packageName;
	
	private List<Table> tableList = new ArrayList<Table>();
	
	public Model(String name){
		this.name = name;
	}
	
	public Table table(String name){
		Table table = new Table(name);		
		tableList.add(table);
		return table;
	}
	
	public Model packageName(String packageName){
		this.packageName = packageName;
		return this;
	}
	
	public void hibernateMap(String fileName) throws Exception{		
		PrintStream out = new PrintStream(new File(fileName));
		String domainPath = this.packageName.replaceAll("\\.", "/");
		domainPath += "/";
		
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<!DOCTYPE hibernate-configuration PUBLIC");
		out.println("\t\t\"-//Hibernate/Hibernate Configuration DTD 3.0//EN\"");
		out.println("\t\t\"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd\">");
		out.println("<hibernate-configuration>");
		out.println("\t<session-factory>");
		
		out.println("\t\t<property name=\"show_sql\">false</property>");
		out.println("\t\t<property name=\"hibernate.validator.apply_to_ddl\">false</property>");
		out.println("\t\t<property name=\"hibernate.validator.autoregister_listeners\">false</property>");
		
		for(Table table:this.tableList){
			out.println("\t\t<mapping resource=\""+domainPath+table.entity+".hbm.xml\" />");
		}
		
		out.println("\t</session-factory>");
		out.println("<hibernate-configuration>");
		
		out.close();
	}
	
	public void hbm(String baseHbm){

	}
	
	public void domain(String baseDomain){
		
	}
}
