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
import com.reusableComponents.HighlightElement // ✨ 객체 강조 기능 추가

// ✅ Suite 실행 시에만 Tapas 로고 클릭
if (GlobalVariable.isSuite) {
    TestObject logo = findTestObject('Object Repository/Tapas 로고')
    WebUI.waitForElementVisible(logo, 10)
    WebUI.waitForElementClickable(logo, 10)
    WebUI.click(logo)
}

WebUI.setText(findTestObject('Object Repository/Prod환경/Home/02.검색/00.검색란'), 'Solo leveling')

WebUI.click(findTestObject('Object Repository/Prod환경/Home/02.검색/01.검색버튼'))

TestObject searchlist = findTestObject('Prod환경/Home/02.검색/03.Solo Leveling 타이틀')
HighlightElement.run(searchlist)
WebUI.verifyElementPresent(searchlist, 0)

// 뒤로 가기 동작
WebUI. back()

WebUI.comment('✅ 완료')
