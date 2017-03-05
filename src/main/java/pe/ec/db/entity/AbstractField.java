package pe.ec.db.entity;

public abstract class AbstractField {
	protected String name;
	protected boolean pk;

	public AbstractField(String name){
		this.name = name;
		this.pk = false;
	}
}
