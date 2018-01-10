package edu.ntou.cse.softwareengineering.ees;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.nio.charset.Charset;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ExhibitionCrawler
{
	private URL mURL;
	
	private ArrayList<Exhibition> mExhibition;
	private Document mDoc;
	
	public ExhibitionCrawler()
	{
		try
		{
			mURL = new URL("http://www.citytalk.tw/cata/57/#!/1991/");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		init();
	}
	
	public ExhibitionCrawler(String url)
	{
		try
		{
			mURL = new URL(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		init();
	}
	
	public ExhibitionCrawler(URL url)
	{
		mURL = url;
		init();
	}
	
	private void init()
	{
		mExhibition = new ArrayList<Exhibition>();
		WebClient mWebClient = new WebClient();
		HtmlPage mPage = null;
		
		try
		{
			mPage = mWebClient.getPage(mURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		mWebClient.waitForBackgroundJavaScript(30 * 1000);
		
		mDoc = Jsoup.parse(mPage.asXml());
		mDoc.charset(Charset.forName("UTF-8"));
		
		mWebClient.close();
		mPage.cleanUp();
	}
	
	public ArrayList<Exhibition> getData()
	{
		parser();
		return mExhibition;
	}
	
	private void parser()
	{
		Elements activities = mDoc.select("section[data-id=search-content] section");
		
		for (int i = 0; i < activities.size(); i++)
		{
			Element aActivity = activities.get(i);
			
			String startDateInString = aActivity.select("time[itemprop=startDate]").get(0).ownText();
			String endDateInString = aActivity.select("time[itemprop=endDate]").get(0).ownText();
			String [] startDateArray = startDateInString.split("-");
			String [] endDateArray = endDateInString.split("-");
			
			int id = 0;
			String name = aActivity.select("figcaption").get(0).ownText();
			Date startDate = new Date(Integer.parseInt(startDateArray[0]), Integer.parseInt(startDateArray[1])-1, Integer.parseInt(startDateArray[2]));
			Date endDate = new Date(Integer.parseInt(endDateArray[0]), Integer.parseInt(endDateArray[1])-1, Integer.parseInt(endDateArray[2]));;
			String location = aActivity.select("span.region").get(0).ownText();
			String information = aActivity.select("p[itemprop=description]").get(0).ownText();
			int hostNum = 0;
			ArrayList<Integer> boothes = null;
			
			Exhibition newExhibition = new Exhibition(id, name, startDate, endDate, location, information, hostNum, boothes);
			mExhibition.add(newExhibition);
		}
	}
	
	public static void main (String args[]) throws Exception
	{
		FileWriter fw = new FileWriter(new File("Exhibition.txt"));
		
		URL u = new URL ("http://www.citytalk.tw/cata/1425/");
		
		//ExhibitionCrawler e = new ExhibitionCrawler();
		//ExhibitionCrawler e = new ExhibitionCrawler("http://www.citytalk.tw/cata/1424/");
		ExhibitionCrawler e = new ExhibitionCrawler(u);
		
		ArrayList<Exhibition> ex = e.getData();
		
		for (Exhibition ee : ex)
		{
			fw.write(ee.toString());			
		}
		
		fw.close();
	}
}
