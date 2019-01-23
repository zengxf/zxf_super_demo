package cn.simple.test.url.read_html;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.simple.test.url.read_html.rule.HrefRule;
import cn.simple.test.url.read_html.rule.HtmlRule;
import cn.simple.test.url.read_html.rule.ImageRule;
import cn.simple.test.url.read_html.rule.TextRule;

public class TestReadMain {

    public static void main(String[] args) {

	String websiteUrl = "http://www.netbian.com";

	String pageUrl = "/desk/9795.htm";

	HtmlRule htmlRule = new HtmlRule();
	htmlRule.labelRule = new TextRule(".action > a", 1);
	htmlRule.imageRule = new ImageRule(".pic > p > img");
	htmlRule.hrefRules.add(new HrefRule(".list > ul > li"));

	HtmlBO entity = read(websiteUrl + pageUrl, htmlRule);

	System.out.println(entity);

	for (String url : entity.hrefUrlList) {
	    System.out.println();
	    entity = read(websiteUrl + url, htmlRule);
	    System.out.println(entity);
	}
    }

    public static HtmlBO read(String url, HtmlRule htmlRule) {

	HtmlBO entity = new HtmlBO();

	try {
	    Connection connect = Jsoup.connect(url);
	    Document doc = connect.get();

	    String label = getText(htmlRule.labelRule, doc);
	    entity.label = label;

	    String title = getText(htmlRule.titleRule, doc);
	    title = title == null ? doc.title() : title;
	    entity.title = title;

	    List<String> imageUrlList = getImageUrlList(htmlRule.imageRule, doc);
	    entity.imageUrlList = imageUrlList;

	    for (HrefRule hrefRule : htmlRule.hrefRules) {
		entity.hrefUrlList.addAll(getHrefUrlList(hrefRule, doc));
	    }

	} catch (IOException e) {
	    // e.printStackTrace();
	    System.err.println(e.getMessage());
	}

	return entity;
    }

    public static String getText(TextRule rule, Document doc) {
	if (rule == null)
	    return null;

	String text = null;

	Elements select = doc.select(rule.cssQuery);
	if (!select.isEmpty()) {
	    try {
		Element element = select.get(rule.index);
		if (element != null)
		    text = element.text();
	    } catch (IndexOutOfBoundsException e) {
		// e.printStackTrace();
		System.err.println("没有找到Text，Err: " + e.getMessage());
	    }
	}

	return text;
    }

    public static List<String> getHrefUrlList(HrefRule rule, Document doc) {
	List<String> list = new ArrayList<>();
	Elements tags = doc.select(rule.listCssQuery); // 选出<li>标签
	for (Element tag : tags) {
	    Elements e = tag.select(rule.itemCssQuery); // 选出<a>标签
	    if (e == null) {
		System.err.println("根据规则没有找到元素！");
	    } else {
		String href = e.get(0).attr(rule.attrKey);
		list.add(href);
	    }
	}
	return list;
    }

    public static List<String> getImageUrlList(ImageRule rule, Document doc) {
	List<String> list = new ArrayList<>();
	String imageUrl = null;
	Elements tags = doc.select(rule.cssQuery); // 选出<img>标签
	if (tags.isEmpty()) {
	    System.err.println();
	} else {
	    for (Element element : tags) {
		imageUrl = element.attr(rule.attrKey);
		list.add(imageUrl);
	    }
	}
	return list;
    }

}
