package pe.ec.db;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<Table> tableList = new ArrayList<Table>();

	public Table table(String name) {
		Table table = new Table(name);
		tableList.add(table);
		return table;
	}
}
