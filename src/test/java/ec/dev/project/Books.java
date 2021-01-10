package ec.dev.project;

import org.junit.Test;

import ec.dev.util.Base;

public class Books extends Base{
	public Books() {
		super("d:\\_", "ec.dev.books");
	}
	@Test
	public void web() {
		web.pom("ec.devs", "books");
		web.web("Books");
		web.springContext("book", "title");
		web.contentWeb("Books", "ECDevs");
	}
	
	@Test
	public void data() {
		data.mapper("Title", "_title", "_id", "id", 
				col("_name", "name"),
				col("_idparent", "idParent"),
				col("_type", "type"));
		data.mapper("Person", "_person", "_id", "id", 
				col("_name", "name"));
		data.mapper("Editorial", "_editorial", "_id", "id", 
				col("_name", "name"));
		data.mapperUpdate("updateBookStatus", "Book", "_title", "_id", "id",
				col("_status", "status"));
		data.mapper("Book", "_book", "_id", "id",
				col("_idtitle","idTitle"));
	}
}
