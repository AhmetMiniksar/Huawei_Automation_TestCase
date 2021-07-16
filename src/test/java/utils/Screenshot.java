package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import models.ScreenshotStatus;

public class Screenshot {

	public static void takeScreenshot(WebDriver driver, String fileName, ScreenshotStatus status) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				
		if(status.equals(ScreenshotStatus.FAILURE)) {
			FileUtils.copyFile(src, new File("./ScreenshotsFailure/" + fileName + ".png"));
			
		}else if(status.equals(ScreenshotStatus.SUCCESS)) {
			FileUtils.copyFile(src, new File("./ScreenshotsSuccess/" + fileName + ".png"));
		}		
		
	}
}
