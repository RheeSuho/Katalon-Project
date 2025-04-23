import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.io.*
import java.util.Set
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.WebDriver


// ✅ 로그인 URL & 쿠키 파일 경로
String url = 'https://tapas.io/account/signin?from=/'
String cookieFilePath = 'cookies.save'

WebDriver driver = DriverFactory.getWebDriver()

// ✅ 쿠키 파일이 존재하면 자동 로그인 시도
File cookieFile = new File(cookieFilePath)

if (cookieFile.exists()) {
	try {
		FileInputStream fis = new FileInputStream(cookieFile)
		ObjectInputStream ois = new ObjectInputStream(fis)
		Set<Cookie> cookies = (Set<Cookie>) ois.readObject()
		ois.close()
		fis.close()

		// ✅ 쿠키 추가
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie)
		}

		// ✅ 쿠키 적용 후 새로고침하여 로그인 확인
		driver.navigate().refresh()
		WebUI.comment('✅ 쿠키 로드 완료! 자동 로그인 성공 시도')
	} catch (Exception e) {
		WebUI.comment('⚠️ 쿠키 로드 실패: ' + e.getMessage())
	}
} else {
	WebUI.comment('❌ 쿠키 파일이 없습니다. 먼저 수동 로그인 후 쿠키를 저장하세요!')
}


WebUI.delay(2)

WebUI.maximizeWindow()
