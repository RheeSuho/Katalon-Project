package com.reusableComponents

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.Assert
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

public class HighlightElement {

	static WebDriver driver = DriverFactory.getWebDriver()

	@Keyword
	public static void run(TestObject objectto) {
		try {
			WebElement element = WebUiCommonHelper.findWebElement(objectto, 20);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			for (int i = 0; i < 1; i++) {
				// 3번 반복으로 변경
				// 요소 강조
				js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 5px solid red;');", element);
				Thread.sleep(500); // 0.5초 대기

				// 원래 스타일로 복원
				js.executeScript("arguments[0].setAttribute('style','background:');", element);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}
