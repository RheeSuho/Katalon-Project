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

//WebUI.callTestCase(findTestCase("Test Cases/CallTest용도/브라우저오픈"), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase("Test Cases/Prod환경/00.메인홈/01.로그인/2222"), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Prod환경/Home/06.작품홈/00.Popular 서브탭'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/06.작품홈/01.1위 작품'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/06.작품홈/03.뷰어 작품 썸네일'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/06.작품홈/04.팝업 작품 썸네일'))

WebUI.verifyElementVisible(findTestObject('Prod환경/Home/06.작품홈/05.작품 타이틀'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/06.작품홈/07.구독버튼'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/06.작품홈/08.팝업취소버튼'))

WebUI.comment("취소버튼완료")

WebUI.click(findTestObject('Object Repository/Prod환경/Home/06.작품홈/09.비활성화버튼'))

WebUI.verifyElementVisible(findTestObject('Prod환경/Home/06.작품홈/10.Unsubscribed토스트'))


WebUI.closeBrowser()

