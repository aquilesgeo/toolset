package pe.ec.winapi;

import java.util.ArrayList;
import java.util.List;

public class Dialog {
	private String idDialog;
	private int modal;
	private List<Field> fieldList = new ArrayList<Field>();

	public Dialog(String idDialog, int modal) {
		this.idDialog = idDialog;
		this.modal = modal;
	}
	
	public void addField(Field field){
		this.fieldList.add(field);
	}
}
