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

WebUI.callTestCase(findTestCase('Test Cases/CallTest용도/검색 용도'), [:], FailureHandling.STOP_ON_FAILURE)

// 최하단까지 스크롤 (11회)
for (int i = 0; i < 11; i++) {
    WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight);', null)

    WebUI.delay(2 // 콘텐츠 로드를 기다림
        )

    TestObject rank300 = findTestObject('Prod환경/Home/02.검색/08.소설-작가의말')

    if (WebUI.verifyElementPresent(rank300, 1, FailureHandling.OPTIONAL)) {
        break
    }
    
    WebUI.verifyElementVisible(findTestObject('Object Repository/Prod환경/Home/02.검색/08.소설-작가의말'))
}

WebUI.closeBrowser()