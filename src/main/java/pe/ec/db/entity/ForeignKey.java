package pe.ec.db.entity;

public class ForeignKey extends AbstractField{
	private Table related;
	private String name;
	
	public ForeignKey(String name, Table related){
		super(name);
		this.related = related;		
	}
	public ForeignKey pk(){
		this.pk = true;
		return this;
	}
}
