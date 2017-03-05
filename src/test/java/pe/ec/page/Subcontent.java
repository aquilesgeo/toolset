package pe.ec.page;

public class Subcontent extends PhpPageTest{
	
	public void contentA(){
		PhpPage php = php("contentA.php");
		php.list("Parties")
			.query("select concat(firstName, ' ', lastName) as name, sex from party")
			.field("Name","name")
			.field("Sex", "sex");
			//.action("Edit","edit.php").p("var","column");
		php.flush();
	}
}
