package pe.ec.db.entity;

import junit.framework.TestCase;

public abstract class ModelTest extends TestCase{
	
	protected final static Type INTEGER = new Type("INTEGER");
	protected final static Type STRING = new Type("STRING");
	protected final static Type LONG = new Type("LONG");
	
	protected Model model(String name){
		Model model = new Model(name);
		return model;
	}
}
