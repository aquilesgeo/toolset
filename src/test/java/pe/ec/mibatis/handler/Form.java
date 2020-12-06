package pe.ec.mibatis.handler;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Form extends Handler {
	private String title;
	private AbstractInput input = null;
	private List<AbstractInput> inputList;
	private String object;

	public Form(String title) {
		this.title = title;
		this.inputList = new ArrayList<AbstractInput>();
	}

	public Form input(String label, String name) {
		this.input = new Input(label, name);
		this.inputList.add(this.input);
		return this;
	}
	
	public Form hidden(String name) {
		this.input = new Hidden(name);
		this.inputList.add(this.input);
		return this;
	}

	public Form value(String value) {
		this.input.value = value;
		return this;
	}

	public Form object(String object) {
		this.object = object;
		return this;
	}

	public Form prop(String value) {
		return value("${" + object + "." + value + "}");
	}
	
	public Form prop() {
		return value("${" + object + "." + input.name + "}");
	}

	public void show(PrintStream out) {
		out.format("\t<form:form title=\"" + this.title + "\" save=\"true\">\r\n");
		for (AbstractInput input : inputList) {
			input.show(out);
		}
		out.println("\t</form:form>");
	}
}

abstract class AbstractInput {
	protected String label = null;
	protected String name;
	protected String value = "";

	protected AbstractInput(String name) {
		this.name = name;
	}

	protected abstract void show(PrintStream out);
}

class Input extends AbstractInput {
	protected Input(String label, String name) {
		super(name);
		this.label = label;
	}

	protected void show(PrintStream out) {
		out.println(
				"\t\t<form:input label=\"" + this.label + "\" name=\"" + this.name + "\" value=\"" + this.value + "\"/>");
	}
}

class Hidden extends AbstractInput {
	protected Hidden(String name) {
		super(name);
	}

	protected void show(PrintStream out) {
		out.println(
				"\t\t<form:hidden name=\"" + this.name + "\" value=\"" + this.value + "\"/>");
	}
}