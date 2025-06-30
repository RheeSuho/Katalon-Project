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
import com.reusableComponents.HighlightElement as HighlightElement
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.WebDriver



//WebUI.callTestCase(findTestCase("Test Cases/CallTest용도/브라우저오픈"), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/CallTest용도/검색 용도'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/27.Accept버튼'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/29.소설옵션버튼'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/32. Lora 폰트'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/33.Lato 폰트'))

WebUI.delay(2) 

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/30.플러스 버튼'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/31.마이너스 버튼'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/34.중앙정렬'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/35.좌측정렬'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/36. 자간 플러스 버튼'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/37.자간 마이너스 버튼'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/38.다크모드'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/39.라이트모드'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/29.소설옵션버튼'))

WebUI.closeBrowser()


