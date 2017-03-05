package pe.ec.db.entity;

public class EBookTempleTest extends ModelTest {
	public void testCreateDataModel(){
		Table book, author;
		Model model = model("ebt")
				.baseDomain("data/")
				.baseHbm("data/");		
		
			book = model.table("Book").sql("_book");
				book.field("id").pk().sql("_id").type(LONG);
				book.field("Name").sql("_name");
				
			author = model.table("Author").sql("_author");
				author.field("id").pk().sql("_id").type(LONG);
				book.field("Name").sql("_name");
			
		model.hibernateMap("etb-hibernate.xml");
	}
}
