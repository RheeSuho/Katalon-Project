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

//WebUI.comment('✅ 배너 실행')

//브라우저 오픈 후 이동
WebUI.callTestCase(findTestCase("Test Cases/CallTest용도/브라우저오픈"), [:], FailureHandling.STOP_ON_FAILURE)

// 브라우저 창 최대화
WebUI.maximizeWindow()

//다음 버튼 확인
TestObject next = findTestObject('Prod환경/Home/04.배너/빅배너/01.빅배너 다음 버튼')
HighlightElement.run(next)
WebUI.verifyElementPresent(next, 0)

//다음 버튼 클릭
WebUI.click(findTestObject('Object Repository/Prod환경/Home/04.배너/빅배너/01.빅배너 다음 버튼'))

//이전 버튼 확인
TestObject prev = findTestObject('Prod환경/Home/04.배너/빅배너/02.빅배너 이전 버튼')
HighlightElement.run(prev)
WebUI.verifyElementPresent(prev, 0)

//이전 버튼 클릭
WebUI.click(findTestObject('Prod환경/Home/04.배너/빅배너/02.빅배너 이전 버튼'))

//자동 스와이프 - 이동 확인을 위한 딜레이 15초 발생
WebUI. delay(10)

// 2페이지 노출 확인
TestObject page2 = findTestObject('Prod환경/Home/04.배너/빅배너/03.2페이지')
HighlightElement.run(page2)
WebUI.verifyElementPresent(page2, 0)

//이전 버튼 확인
TestObject prev1 = findTestObject('Prod환경/Home/04.배너/빅배너/02.빅배너 이전 버튼')
HighlightElement.run(prev1)
WebUI.verifyElementPresent(prev1, 0)

//이전 버튼 클릭
WebUI.click(findTestObject('Prod환경/Home/04.배너/빅배너/02.빅배너 이전 버튼'))

//빅배너 선택
WebUI.click(findTestObject('Object Repository/Prod환경/Home/04.배너/빅배너/04.빅배너이미지'))

//랜딩 확인을 위한 2초 딜레이
WebUI. delay(1)

//랜딩 후 작품 확인
TestObject title = findTestObject('Prod환경/Home/04.배너/빅배너/08.작품이미지')
HighlightElement.run(title)
WebUI.verifyElementPresent(title, 0)

//정상적인 작품 랜딩확인을 위한 딜레이 1초
WebUI. delay(1)

//뒤로가기
WebUI.back()

//복귀 후 배너 확인
TestObject bancheck = findTestObject('Prod환경/Home/04.배너/빅배너/04.빅배너이미지')
HighlightElement.run(bancheck)
WebUI.verifyElementPresent(bancheck, 0)

//브라우저 닫기
WebUI.closeBrowser()	

WebUI.comment('✅ 빅배너 완료')






