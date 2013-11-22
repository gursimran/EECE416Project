package com.anything.ubc.EECE416Project2;

import java.sql.Savepoint;

public class Data {

	private static String AboutUsUrl = "http://broadmoorbakery.com/index.html#";
	private static String MenuUrl = "http://broadmoorbakery.com/menu.html";
	private static String ServicesUrl = "http://broadmoorbakery.com/services.html";
	private static String ContactUrl = "http://broadmoorbakery.com/contact.html";
	private static String baseUrl = "http://broadmoorbakery.com/";
	private static String facebookUrl = "https://www.facebook.com/pages/Broadmoor-Bakery/140827085987125?ref=ts";
	private static String cakesUrl = "http://broadmoorbakery.com/menu.html";
	private static String piesUrl = "http://broadmoorbakery.com/pies.html";
	private static String  breadsUrl = "http://broadmoorbakery.com/bread.html";
	private static String pasteriesUrl = "http://broadmoorbakery.com/pastry.html";
	private static String cookiesUrl = "http://broadmoorbakery.com/cookies.html";
	private static String savoresUrl = "http://broadmoorbakery.com/savories.html";
	private static String miscUrl = "http://broadmoorbakery.com/misc.html";
	private static String googleMapsUrl = "https://maps.google.ca/maps?f=q&source=embed&hl=en&geocode=&q=Broadmoor+Bakery,+Williams+Road,+Richmond,+British+Columbia&aq=0&sll=49.891235,-97.15369&sspn=60.630088,77.255859&ie=UTF8&hq=Broadmoor+Bakery,&hnear=Williams+Rd,+Richmond,+British+Columbia&ll=49.140646,-123.137652&spn=0.004913,0.00912&z=16&iwloc=A";
	
	private static String[] URLs = {AboutUsUrl, MenuUrl, ServicesUrl, ContactUrl, baseUrl, facebookUrl, googleMapsUrl};
	private static String[] menuUrls = {cakesUrl, piesUrl, breadsUrl, pasteriesUrl, cookiesUrl, savoresUrl, miscUrl};
	
	
	public static String getUrl(int i){
		return URLs[i];
	}
	
	public static String getMenuUrl(int i){
		return menuUrls[i];
	}
}
