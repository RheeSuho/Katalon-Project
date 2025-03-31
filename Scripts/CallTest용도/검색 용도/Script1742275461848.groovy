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

WebUI.comment('✅ 로그인/검색 실행')

WebUI.callTestCase(findTestCase('Test Cases/Prod환경/00.메인홈/01.로그인/01.자동 로그인 확인'), [:], FailureHandling.STOP_ON_FAILURE)

//callTestcase 용이므로 검색어는 그때마다 변경 가능
WebUI.setText(findTestObject('Object Repository/Prod환경/Home/02.검색/00.검색란'), 'Soft Touch')

WebUI.click(findTestObject('Object Repository/Prod환경/Home/02.검색/01.검색버튼'))


//다음 구문 주석 처리하는 경우 - 코믹탭으로 사용 가능 (다른 탭은 추가해야함)
WebUI.click(findTestObject('Object Repository/Prod환경/Home/02.검색/07.Novel탭'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/02.검색/06.검색작품섬네일'))
