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

WebUI.comment('✅ 프로모션 배너 실행')

WebUI.callTestCase(findTestCase("Test Cases/CallTest용도/브라우저오픈"), [:], FailureHandling.STOP_ON_FAILURE)

TestObject promotion = findTestObject('Prod환경/Home/04.배너/프로모션 배너/프로모션배너확인')
HighlightElement.run(promotion)
WebUI.verifyElementPresent(promotion, 0)


WebUI.click(findTestObject('Object Repository/Prod환경/Home/04.배너/프로모션 배너/프로모션배너확인'))

TestObject contents = findTestObject('Prod환경/Home/04.배너/프로모션 배너/프로모션 배너 타이틀')
HighlightElement.run(contents)
WebUI.verifyElementPresent(contents, 0)


WebUI.back()
WebUI.refresh()

WebUI.comment('✅ 프로모션 배너 완료')
