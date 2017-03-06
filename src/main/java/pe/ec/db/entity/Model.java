package pe.ec.db.entity;

import java.util.ArrayList;
import java.util.List;

public class Model {
	private String name;
	private String baseDomain;
	private String baseHbm;
	private List<Table> tableList = new ArrayList<Table>();
	
	public Model(String name){
		this.name = name;
	}
	
	public Table table(String name){
		Table table = new Table(name);
		tableList.add(table);
		return table;
	}
	
	public void hibernateMap(String fileName){
		
	}
	
	public void hbm(String baseHbm){
		
	}
	
	public void domain(String baseDomain){
		
	}
}
