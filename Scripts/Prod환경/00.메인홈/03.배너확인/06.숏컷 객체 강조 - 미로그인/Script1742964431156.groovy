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

// 객체 찾기 및 강조
TestObject searchBox = findTestObject('Object Repository/Prod환경/Home/01.메인홈/숏컷/00.검색란')
HighlightElement.run(searchBox)
WebUI.verifyElementPresent(searchBox, 1)


TestObject logoImage = findTestObject('Object Repository/Prod환경/Home/01.메인홈/숏컷/01.검색버튼')
HighlightElement.run(logoImage)
WebUI.verifyElementPresent(logoImage, 1)


TestObject loginButton = findTestObject('Prod환경/Home/01.메인홈/숏컷/로그인버튼')
HighlightElement.run(loginButton)
WebUI.verifyElementPresent(loginButton, 1)


TestObject publishButton = findTestObject('Prod환경/Home/01.메인홈/숏컷/06.Publish버튼')
HighlightElement.run(publishButton)
WebUI.verifyElementPresent(publishButton, 1)

WebUI.comment('✅ Test 1 완료. 브라우저 유지 상태에서 Test 2 실행')



