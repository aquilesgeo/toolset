package pe.ec.mibatis.handler;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Table extends Handler{
	String name;
	String alias;
	String entity;
	String idName = "ID";
	String idProperty = "id";
	
	String packageName;

	List<Column> columnList = new ArrayList<Column>();

	public Table(String name, String packageName) {
		this.packageName = packageName;
		this.name = name;
		this.alias = name;
		this.entity = name;
	}
	
	public Table id(String name, String property) {
		this.idName = name;
		this.idProperty = property;
		return this;
	}

	public Table alias(String alias) {
		this.alias = alias;
		return this;
	}

	public Table entity(String entity) {
		this.entity = entity;
		return this;
	}

	public Table col(String name, String property) {
		Column column = new Column();
		column.name = name;
		column.property = property;
		this.columnList.add(column);
		return this;
	}

	public Table resultMap(PrintStream out) {
		System.out.println("\t<resultMap id=\"" + alias + "Map\"\r\n" + "\t\ttype=\""+packageName+".model."
				+ entity + "\">\r\n" + "\t\t<id property=\""+idProperty+"\" column=\""+idName+"\" />");
		for (Column column : columnList) {
			System.out.println("\t\t<result property=\"" + column.property + "\" column=\"" + column.name + "\" />");
		}
		System.out.println("\t</resultMap>");
		System.out.println();
		return this;
	}

	public Table get(PrintStream out) {
		System.out.println("\t<select id=\"get" + entity + "\" resultMap=\"" + alias + "Map\" parameterType=\"long\">");
		System.out.println("\t\tselect * from " + name.toUpperCase() + " where "+idName+"=#{id}");
		System.out.println("\t</select>");
		System.out.println();
		return this;
	}

	public Table list(PrintStream out, String order) {
		System.out.println("\t<select id=\"list" + entity + "s\" resultMap=\"" + alias + "Map\">");
		System.out.println("\t\tselect * from " + name.toUpperCase() + " order by " + order);
		System.out.println("\t</select>");
		System.out.println();
		return this;
	}

	public Table insert(PrintStream out) {
		System.out.println(
				"\t<insert id=\"insert" + entity + "\" useGeneratedKeys=\"true\" keyColumn=\""+idName+"\" keyProperty=\""+idProperty+"\">");
		System.out.print("\t\tinsert into " + name + " (");
		boolean first = true;
		for (Column column : columnList) {
			if (first) {
				first = false;
			} else {
				System.out.print(", ");
			}
			System.out.print("`"+column.name.toUpperCase()+"`");
		}
		System.out.println(") values");
		System.out.print("\t\t(");
		first = true;
		for (Column column : columnList) {
			if (first) {
				first = false;
			} else {
				System.out.print(", ");
			}
			System.out.print("#{" + alias + "." + column.property + "}");
		}
		System.out.println(")");
		System.out.println("\t</insert>");
		System.out.println();
		return this;
	}

	public Table update(PrintStream out) {
		System.out.println("\t<update id=\"update" + entity + "\">");
		System.out.println("\t\tupdate " + name + " set ");
		boolean first = true;
		for (Column column : columnList) {
			if (first) {
				first = false;
			} else {
				System.out.println(", ");
			}
			System.out.print("\t\t\t`" + column.name.toUpperCase() + "` = #{" + alias + "." + column.property + "}");
		}
		System.out.println();
		System.out.println("\t\twhere "+idName+"=#{" + alias + "."+idProperty+"}");
		System.out.println("\t</update>");
		System.out.println();
		return this;
	}

	public void show(PrintStream out) {
		resultMap(out);
		get(out);
		update(out);
		insert(out);
	}
}

class Column {
	String name;
	String property;
}