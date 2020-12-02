package pe.ec.mibatis.handler;

import java.io.PrintStream;

public class Insert extends Handler {
	public String tableName;
	public String capitalName;
	private String[] fields;
	private String keyId = "id";

	public Insert(String tableName, String[] fields) {
		this.tableName = tableName;
		this.capitalName = tableName.substring(0, 1).toUpperCase() + tableName.substring(1);
		this.fields = fields;
	}

	public String fields(String prefix, String postfix) {
		boolean first = true;
		String total = "";
		for (String field : fields) {
			if (first) {
				first = false;
			} else {
				total += ", ";
			}
			total += prefix + field + postfix;
		}
		return total;
	}

	public void mapping(PrintStream out) {
		out.format(
				"<insert id=\"insert%s\" useGeneratedKeys=\"true\" keyProperty=\"%s\">\r\n" + 
				"  insert into %s (%s)\r\n" + 
				"  values (%s)\r\n" + 
				"</insert>\r\n",
				capitalName, keyId, tableName, fields("", ""), fields("#{", "}"));
	}
}
