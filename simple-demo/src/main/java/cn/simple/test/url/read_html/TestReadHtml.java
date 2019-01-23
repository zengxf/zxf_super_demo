package cn.simple.test.url.read_html;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestReadHtml {

    public static void main(String[] args) throws IOException {
	Connection connect = Jsoup.connect("http://www.netbian.com/desk/9795.htm");
	Document doc = connect.get();

	// Element link = doc.select("a").first();
	Elements title = doc.getElementsByTag("title");
	System.out.println(title.get(0).text());
	System.out.println(doc.title());

	Elements img = doc.select(".pic > p > img");
	System.out.println(img.get(0).attr("src"));
	
	Elements label = doc.select(".action > a[href~=/.+]");
	System.out.println(label.get(0).text());

	Elements list = doc.select(".list > ul > li");
	for (Element li : list) {
	    System.out.println(li.select("a").attr("href"));
	}

    }

}
