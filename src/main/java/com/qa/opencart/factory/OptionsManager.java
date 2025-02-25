package com.qa.opencart.factory;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class OptionsManager {

	private Properties prop;
	private ChromeOptions co;
	private EdgeOptions eo;
	private static final Logger log = LogManager.getLogger(DriverFactory.class);

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			// System.out.println("==Running in headless mode");
			log.info("==Running in headless mode");
			co.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			// System.out.println("==Running in incognito mode");
			log.info("==Running in incognito mode");
			co.addArguments("--incognito");
		}
		return co;
	}

	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			// System.out.println("==Running in headless mode");
			log.info("==Running in headless mode");
			eo.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			// System.out.println("==Running in incognito mode");
			log.info("==Running in incognito mode");
            eo.addArguments("--inPrivate");
		}
		return eo;
	}
}
