package com.tutorialsninja.automation.stepdef;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Browser;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    public static Logger log = Logger.getLogger(Hooks.class);

    @Before
    public void setUp(Scenario scenario) {
        log.info("[setUp] Scenario Started: " + scenario.getName());
        Base.driver = Browser.startBrowser();
        Browser.maximize();
    }

    @After
    public void closeBrowser(Scenario scenario) {
        log.info("[closeBrowser] Scenario Completed: " + scenario.getName());
        log.info("[closeBrowser] Scenario Status is: " + scenario.getStatus());
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)Base.driver).getScreenshotAs(OutputType.BYTES);
            if (screenshot != null) {
                scenario.embed(screenshot, "image/png");
            } else {
                log.info("Screenshot data is null, skipping embedding");
            }
        }
        if (Base.driver != null) {
            Base.driver.quit();
        } else {
            log.info("WebDriver instance is null, cannot quit browser");
        }
    }
}

