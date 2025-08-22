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


WebUI.callTestCase(findTestCase("Test Cases/CallTest용도/브라우저오픈"), [:], FailureHandling.STOP_ON_FAILURE)

// Popular 서브탭 클릭
WebUI.click(findTestObject('Object Repository/Prod환경/Home/05.서브탭/00.popular 버튼'))

// 최하단까지 스크롤 (11회)
for (int i = 0; i < 11; i++) { 
    WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);", null)
    WebUI.delay(2) // 콘텐츠 로드를 기다림

    TestObject rank300 = findTestObject('Object Repository/Prod환경/Home/05.서브탭/01.300위작품')

    if (WebUI.verifyElementPresent(rank300, 2, FailureHandling.OPTIONAL)) {
        break // 300위 작품이 나타나면 루프 종료
    }
}

// 300위 작품 찾기
TestObject rank300 = findTestObject('Prod환경/Home/05.서브탭/01.300위작품')
HighlightElement.run(rank300)
WebUI.verifyElementPresent(rank300, 5, FailureHandling.STOP_ON_FAILURE)

WebUI.executeJavaScript("window.scrollTo(0, 0);", null) 

// 소설 탭 클릭
WebUI.click(findTestObject('Object Repository/Prod환경/Home/05.서브탭/02.Novel버튼'))

// 소설탭 로드 확인
WebUI.waitForPageLoad(10)
TestObject P_novel = findTestObject('Prod환경/Home/05.서브탭/02.Novel버튼')
HighlightElement.run(P_novel)
WebUI.verifyElementPresent(P_novel, 5, FailureHandling.STOP_ON_FAILURE)

WebUI.comment('✅ popular 서브탭 실행 완료')
