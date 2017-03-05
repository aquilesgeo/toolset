package pe.ec.page;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class PhpPage {
	private String fileName;
	private List<HtmlContent> contentList = new ArrayList<HtmlContent>();
	private List<String> includeList = new ArrayList<String>();

	public PhpPage(String fileName) {
		this.fileName = fileName;
	}

	public HtmlList list(String name) {
		HtmlList list = new HtmlList(name);
		this.contentList.add(list);
		return list;
	}

	public PhpPage include(String include) {
		this.includeList.add(include);
		return this;
	}

	public void flush() {
		try {
			FileOutputStream output = new FileOutputStream(this.fileName);
			PrintStream out = new PrintStream(output);

			out.println("<?php");
			for (String include : this.includeList) {
				out.println("include \"" + include + "\";");
			}
			out.println("?>");
			
			for (HtmlContent content : contentList) {
				content.generateContent(out);
			}
			output.flush();
			output.close();
		} catch (Exception e) {

		}
	}
}
