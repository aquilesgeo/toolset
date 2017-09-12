package pe.ec.winapi;

import org.junit.After;

public abstract class AbstractWinapi {
	public final static int MODAL = 0;
	public final static int MODELESS = 1;
	
	private Dialog dialog;
	
	protected Dialog dialog(String idDialog, int modal){
		this.dialog = new Dialog(idDialog, modal);
		return this.dialog;
	}
	
	protected Field text(String idText, String variable){
		Field field = new Field(idText, variable);
		this.dialog.addField(field);
		return field;
	}
	
	protected Field integer(String idText, String variable){
		Field field = new Field(idText, variable);
		this.dialog.addField(field);
		return field;
	}
	
	@After
	public void generate(){
		System.out.println("Generate");
	}
}
