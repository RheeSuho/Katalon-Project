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

WebUI.callTestCase(findTestCase('Test Cases/Prod환경/00.메인홈/01.로그인/01.자동 로그인 확인'), [:], FailureHandling.STOP_ON_FAILURE)




TestObject searchBox = findTestObject('Object Repository/Prod환경/Home/01.메인홈/숏컷/00.검색란')
HighlightElement.run(searchBox)
WebUI.verifyElementPresent(searchBox, 1)


TestObject logoImage = findTestObject('Object Repository/Prod환경/Home/01.메인홈/숏컷/01.검색버튼')
HighlightElement.run(logoImage)
WebUI.verifyElementPresent(logoImage, 1)


TestObject loginButton = findTestObject('Object Repository/Prod환경/Home/01.메인홈/숏컷/03.library버튼')
HighlightElement.run(loginButton)
WebUI.verifyElementPresent(loginButton, 1)


TestObject inboxbutton = findTestObject('Object Repository/Prod환경/Home/01.메인홈/숏컷/04.inbox버튼')
HighlightElement.run(inboxbutton)
WebUI.verifyElementPresent(inboxbutton, 1)

TestObject profileimage = findTestObject('Object Repository/Prod환경/Home/01.메인홈/숏컷/05.프로필이미지버튼')
WebUI.waitForElementVisible(profileimage, 5)  // ✅ 최대 5초까지 기다림
HighlightElement.run(profileimage)
WebUI.verifyElementPresent(profileimage, 1)

TestObject publishButton1 = findTestObject('Object Repository/Prod환경/Home/01.메인홈/숏컷/07.로그인publish버튼')
HighlightElement.run(publishButton1)
WebUI.verifyElementPresent(publishButton1, 1)

WebUI.comment('✅ Test 1 완료. 브라우저 유지 상태에서 Test 2 실행')



