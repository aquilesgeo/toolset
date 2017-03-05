package pe.ec.db.entity;

public class EBookTempleTest extends ModelTest {
	public void testCreateDataModel() throws Exception{
		Table book, party, author, item;
		Model model = model("ebt").packageName("pe.ec.ebt.domain");
			
			book = model.table("book").sql("_book");
				book.field("id").pk().sql("_id").type(LONG);
				book.field("name").sql("_name");
				
			party = model.table("party").sql("_party");
				party.field("id").pk().sql("_id").type(LONG);
				party.field("firstName").sql("_firstname");
				party.field("lastName").sql("_lastname");
				
			author = model.table("Author").sql("_author");
				author.fk("party", party).pk();
				author.fk("book", book).pk();
				
			item = model.table("item").sql("_item");
				item.field("id").pk().sql("_id").type(LONG);
				item.fk("book", book);
				item.field("language").sql("_language");

		model.hibernateMap("data/etb-hibernate.xml");
		model.domain("data/");
		model.hbm("data/");
	}
}
