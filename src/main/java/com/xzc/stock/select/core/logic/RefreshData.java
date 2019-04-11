package com.xzc.stock.select.core.logic;

import java.net.ConnectException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.util.NodeList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xzc.stock.download.core.logic.dao.DownloadDao;
import com.xzc.stock.download.core.logic.entity.BasicData;
import com.xzc.stock.select.core.util.CommonMethod;

@RestController
public class RefreshData extends CommonMethod {

	private static final String baseurl = "https://www.nasdaq.com/symbol/";
	private NodeList nodelist = null;
	private List<BasicData> list = null;
	private BasicData temp = null;
	private boolean flag = false;
	private boolean update = false;
	private String date = null;
	private DownloadDao dao = null;

	@RequestMapping("update")
	public synchronized String update(@RequestParam String name)
			throws Exception {

		String[] names = name.substring(1).split(",");

		for (String na : names) {
			System.out.println("start sleeping:    " + na);
			Thread.sleep(1000 * 60);
			System.out.println("stop sleeping:    " + na);
			
			String url = baseurl + na + "/historical";
			dao = new DownloadDao();
			URL u = new URL(url);
			try {
				System.out.println("start connecting:    " + u.toString());
				nodelist = getNodeList(u);
			} catch (ConnectException e) {
				System.out.println("chaoshile");
			}

			for (int k = 140; k <= 141; k++) {
				try {
					String str = getHtmlBody(nodelist, k);
					Pattern CRLF = Pattern.compile("(\r\n|\r|\n|\n\r)");
					Matcher m = CRLF.matcher(str);

					if (m.find()) {
						str = m.replaceAll("<br>");
					}

					str = str.replaceAll("<[^>]*>", "<>");
					str = str.replaceAll(" ", "");
					str = str
							.substring(str
									.indexOf("<><><><><><><><><><><><><><><><><><><><><><>") + 44);
					date = read(na);
					System.out.println(date);
					if (str.indexOf(date) > 0 && (date != " ")) {
						str = str.substring(0, str.indexOf(date));
						String[] detail = str.split("<><><><><><><><><><>");
						if (detail.length > 1) {
							list = new ArrayList<BasicData>();
							int n = detail.length;
							for (int i = n - 1; i >= 0; i--) {
								String[] data = detail[i].split("<><><><><>");
								String date1 = data[0];
								if (date1.contains("<>"))
									continue;
								date1 = dateTransform(date1);
								temp = setData(date1, data[1], data[3],
										data[2], data[4], data[5], na);
								dao.addBasicUser(temp);
							}
						} else if (detail.length == 1) {
							String[] data = detail[0].split("<><><><><>");
							if (data.length > 1) {
								String date1 = data[0];
								if (!date1.contains("<>")) {
									date1 = dateTransform(date1);
									temp = setData(date1, data[1], data[3],
											data[2], data[4], data[5], na);
									dao.addBasicUser(temp);
								}
							}
						}
						update = true;
					} else {
						String[] detail = null;
						detail = str.split("<><><><><><><><><><>");
						list = new ArrayList<BasicData>();
						int n = detail.length;
						try {
							for (int i = n - 1; i >= 0; i--) {
								String[] data = detail[i].split("<><><><><>");
								String date1 = data[0];
								if (date1.contains("<>"))
									continue;
								date1 = dateTransform(date1);
								temp = setData(date1, data[1], data[3],
										data[2], data[4], data[5], na);
								dao.addBasicUser(temp);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						update = true;
					}

				} catch (Exception e) {
					continue;
				}
			}
		}
		if(update) return "success";
		return "xxxx";
	}

	public String read(String name) throws Exception {

		String newdate = " ";
		try {
			String date1 = readFromDataBase(name);
			DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/yyyy",
					Locale.ENGLISH);
			DateTimeFormatter f1 = DateTimeFormatter.ofPattern("yyyy/M/d",
					Locale.ENGLISH);
			LocalDate date = LocalDate.parse(date1, f1);
			newdate = date.format(f);
		} catch (Exception e) {
		}
		return newdate;
	}

	public String dateTransform(String date) throws Exception {
		String d2 = " ";
		try {
			DateTimeFormatter f1 = DateTimeFormatter.ofPattern("MM/dd/yyyy",
					Locale.ENGLISH);
			LocalDate d1 = LocalDate.parse(date, f1);
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/M/d",
					Locale.ENGLISH);
			d2 = d1.format(f);
		} catch (Exception e) {
		}
		return d2;
	}

	public BasicData setData(String date1, String startPrice, String lowPrice,
			String highPrice, String endPrice, String v, String name) {
		BasicData temp = new BasicData();

		temp.setDate(date1);
		temp.setStartPrice(startPrice);
		temp.setLowPrice(lowPrice);
		temp.setHighPrice(highPrice);
		temp.setEndPrice(endPrice);
		temp.setVolume(v.replaceAll(",", ""));
		temp.setName(name);
		return temp;
	}

	public String readFromDataBase(String name) throws Exception {
		return dao.getStockDateByName(name);

	}

	public static void main(String[] args) throws Exception {
		RefreshData re = new RefreshData();
		String flag = re.update("GEVO");
		System.out.println("the flag is " + flag);
		// re.delete("SFS");
	}
}
