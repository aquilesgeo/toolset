package pe.ec.page;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class HtmlList extends HtmlContent{
	String name;
	String query;
	String object;
	String resultSet;
	List<Field> fields = new ArrayList<Field>();
	
	public HtmlList query(String query){		
		return query("rset", query);
	}
	
	public HtmlList object(String object){
		this.object = object;
		return this;
	}
	
	public HtmlList query(String resultSet, String query){
		this.query = query;
		this.resultSet = resultSet;
		return this;
	}
	
	public HtmlList field(String title, String column){
		Field field = new Field();
		field.title = title;
		field.column = column;
		fields.add(field);
		return this;
	}
	
	public HtmlList(String name){
		this.name = name;
		this.query = "rset";
		this.object = "obj";
	}
	
	public void generateContent(PrintStream out){
		
		out.println("<?php");
		out.println("\t$sql = \""+this.query+"\";");
		out.println("\t$"+this.resultSet+" = mysql_query($sql);");
		out.println("?>");
		
		out.println("<table>");
		out.println("<tr>");
		for(Field field:this.fields){
			out.println("<th>"+field.title+"</th>");
		}
		out.println("</tr>");
		out.println("\t<?php");
		out.println("\twhile(($"+this.object+"=mysql_fetch_object($"+this.resultSet+"))!=0){");
		out.println("\t\t?>");
		
		out.println("\t\t<tr>");
		
		for(Field field:fields){
			out.println("\t\t\t<td><?=$"+this.object+"->"+field.column+"?></td>");
		}
		
		out.println("\t\t</tr>");
		
		out.println("\t\t<?php");
		out.println("\t}");		
		out.println("?>");
		
		out.println("</table>");		
		
	}
}

class Field {
	String title;
	String column;
}

class Action {
	String title;
	String url;
	String js;
	List<ActionParam> params = new ArrayList<ActionParam>();
}

class ActionParam{
	
}