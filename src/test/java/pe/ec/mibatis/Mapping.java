package pe.ec.mibatis;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pe.ec.mibatis.handler.Handler;
import pe.ec.mibatis.handler.Insert;
import pe.ec.mibatis.handler.Table;

public class Mapping {

	private String packageName;
	List<Handler> handlerList = new ArrayList<Handler>();

	Mapping(String packageName) {
		this.packageName = packageName;
	}

	public Insert insert(String tableName, String... fields) {
		Insert handler = new Insert(tableName, fields);
		handlerList.add(handler);
		return handler;
	}

	public Table table(String tableName) {
		return new Table(tableName, this.packageName);
	}

	public void mapping() {
		PrintStream out = System.out;
		for (Handler handler : handlerList) {
			handler.mapping(out);
		}
	}
}
