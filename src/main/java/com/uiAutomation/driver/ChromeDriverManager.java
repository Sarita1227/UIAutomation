package com.uiAutomation.driver;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
	
	private ChromeDriverService chService;
	

    @Override
	public void startService() {
		if (null == chService) {
			try {
				chService = new ChromeDriverService.Builder()
	                    .usingDriverExecutable(new File("Chromedriver/chromedriver.exe"))
	                    .usingAnyFreePort()
	                    .build();
				chService.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

    @Override
    public void stopService() {
        if (null != chService && chService.isRunning())
            chService.stop();
    }

    @Override
	public void createDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandboxes");
		options.addArguments("--start-fullscreen");
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(chService, options);
	}

}
