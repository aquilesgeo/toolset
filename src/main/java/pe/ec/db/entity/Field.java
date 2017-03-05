package pe.ec.db.entity;

public class Field {
	private String name;
	private String sql;
	private Type type;
	private boolean pk;

	public Field(String name) {
		this.name = name;
		this.pk = false;
	}
	
	public Field sql(String sql){
		this.sql = sql;
		return this;
	}
	
	public Field type(Type type){
		this.type = type;
		return this;
	}
	
	public Field pk(){
		this.pk = true;
		return this;
	}
}
