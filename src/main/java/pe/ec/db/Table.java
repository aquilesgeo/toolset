package pe.ec.db;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private String name;
	private String entitiy;

	private List<Field> fieldList = new ArrayList<Field>();

	public Table(String name) {
		this.name = name;
	}

	public Table entity(String entity) {
		this.entitiy = entity;
		return this;
	}

	public Field field(String name) {
		Field field = new Field(name);
		fieldList.add(field);
		return field;
	}
}
