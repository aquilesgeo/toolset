package pe.ec.db.entity;

public class Field extends AbstractField {
	private String sql;
	private Type type;

	public Field(String name) {
		super(name);
	}

	public Field sql(String sql) {
		this.sql = sql;
		return this;
	}

	public Field type(Type type) {
		this.type = type;
		return this;
	}

	public Field pk() {
		this.pk = true;
		return this;
	}
}
