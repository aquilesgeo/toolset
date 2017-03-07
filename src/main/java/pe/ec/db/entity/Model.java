package pe.ec.db.entity;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import pe.ec.util.TemplateEngine;

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
		String domainPath = this.packageName.replaceAll("\\.", "/");
		domainPath += "/";
		
		TemplateEngine.instance()
			.v("mapList", this.tableList)
			.v("domainPath", domainPath)
			.template("vm/db/hibernate-hbm-xml.vm")
			.generate(fileName);
	}
	
	public void hbm(String baseHbm){

	}
	
	public void domain(String baseDomain){
		
	}
}
