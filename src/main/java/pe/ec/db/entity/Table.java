package pe.ec.db.entity;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private String name;
	private String sql;
	
	private List<Field> fieldList = new ArrayList<Field>();
	private List<ForeignKey> relatedList = new ArrayList<ForeignKey>();

	public Table(String name) {
		this.name = name;
	}
	
	public Table sql(String sql){
		this.sql = sql;
		return this;
	}
	
	public Field field(String name){
		Field field = new Field(name);
		this.fieldList.add(field);
		return field;
	}
	
	public ForeignKey fk(String name, Table related){
		ForeignKey fk=new ForeignKey(name, related);
		this.relatedList.add(fk);
		return fk;
	}
}
