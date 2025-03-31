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
import com.kms.katalon.core.testobject.TestObject as TestObject
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.io.*
import java.util.Set

// ✅ 로그인 페이지 열기
String url = 'https://tapas.io/account/signin?from=/'
String cookieFilePath = 'cookies.save' // 쿠키 저장 파일 경로

WebUI.openBrowser('')
WebUI.navigateToUrl(url)

WebDriver driver = DriverFactory.getWebDriver()

// ✅ 사용자가 수동으로 CAPTCHA 입력할 시간을 제공
WebUI.comment('⏳ 수동으로 로그인하세요 (CAPTCHA 입력 필요)')
WebUI.delay(30) // 30초 동안 기다림 (CAPTCHA 입력 시간)

// ✅ 로그인 후 쿠키 저장
try {
	Set<Cookie> cookies = driver.manage().getCookies()
	FileOutputStream fos = new FileOutputStream(cookieFilePath)
	ObjectOutputStream oos = new ObjectOutputStream(fos)
	oos.writeObject(cookies)
	oos.close()
	fos.close()

	WebUI.comment('✅ 쿠키 저장 완료! 이후 자동 로그인에 사용 가능')
} catch (Exception e) {
	WebUI.comment('⚠️ 쿠키 저장 실패: ' + e.getMessage())
}

WebUI.closeBrowser()
