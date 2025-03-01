package com.tutorialsninja.automation.config;

public interface ConfigurationReader {
	
	public String getUrl(); // for property this is a method get url
	public String getBrowser();
	public int getPageLoadTimeOut(); // these all are methods for every property

}
