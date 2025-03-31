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

//WebUI.callTestCase(findTestCase("Test Cases/CallTest용도/브라우저오픈"), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Prod환경/00.메인홈/01.로그인/01.자동 로그인 확인'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/Prod환경/Home/02.검색/00.검색란'), 'The Boy & the Wolf')

WebUI.click(findTestObject('Object Repository/Prod환경/Home/02.검색/01.검색버튼'))

WebUI.click(findTestObject('Object Repository/Prod환경/Home/07.뷰어/00.썸네일'))

// ✅ 여러 개의 요소를 한 번에 확인하는 코드 적용
List<String> objectList = [
    'Object Repository/Prod환경/Home/07.뷰어/08.썸네일',
    'Object Repository/Prod환경/Home/07.뷰어/09.회차명',
    'Object Repository/Prod환경/Home/07.뷰어/10.뷰카운트',
    'Object Repository/Prod환경/Home/07.뷰어/11.좋아요수',
    'Object Repository/Prod환경/Home/07.뷰어/12.댓글수',
    'Object Repository/Prod환경/Home/07.뷰어/13.more버튼',
    'Object Repository/Prod환경/Home/07.뷰어/14.support버튼',
    'Object Repository/Prod환경/Home/07.뷰어/15.회차리스트버튼',
	'Object Repository/Prod환경/Home/07.뷰어/16.댓글버튼',
	'Object Repository/Prod환경/Home/07.뷰어/17.이전버튼',
	'Object Repository/Prod환경/Home/07.뷰어/18.다음버튼',
	'Object Repository/Prod환경/Home/07.뷰어/19.전체화면버튼'
]

for (String objectPath : objectList) {
    WebUI.verifyElementVisible(findTestObject(objectPath))
}

WebUI.closeBrowser()
      
