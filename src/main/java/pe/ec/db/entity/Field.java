package pe.ec.db.entity;

public class Field {
	private String name;
	private String sql;

	public Field(String name) {
		this.name = name;
	}
	
	public Field sql(String sql){
		this.sql = sql;
		return this;
	}
}
