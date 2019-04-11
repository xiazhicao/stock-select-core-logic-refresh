package com.xzc.stock.select.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.HtmlPage;

public class CommonMethod {
	
	private final static String CRLF = System.getProperty("line.separator");
	
	public static NodeList getNodeList(URL url) throws IOException{
		InputStream instr = url.openStream();
	    String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(instr));
        StringBuffer sb = new StringBuffer();
        while ((s = in.readLine()) != null) {
            sb.append(s + CRLF); // ��ȡ��ҳ��Ϣ�������ַ���������
        }
        Parser parser = Parser.createParser(sb.toString(), "GBK"); // ���������ҳ�Ļ���������������
        HtmlPage page = new HtmlPage(parser); // �ѽ�������������htmlpage
        try {
            parser.visitAllNodesWith(page);
        } catch (ParserException e1) {
            e1 = null;
        }
        NodeList nodelist = page.getBody(); // �����ҳ��body����
        TagNameFilter filter = new TagNameFilter("div"); 
        return nodelist.extractAllNodesThatMatch(filter, true);
	}
	
	public static String getHtmlBody(NodeList nodeList, int rownum){
		Div div = (Div) nodeList.elementAt(rownum);
		return div.toHtml();
	}
	
}
