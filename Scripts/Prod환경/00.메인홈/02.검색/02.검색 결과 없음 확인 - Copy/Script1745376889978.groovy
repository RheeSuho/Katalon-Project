 //import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
//import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
//import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
//import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
//import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
//import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
//import com.kms.katalon.core.model.FailureHandling as FailureHandling
//import com.kms.katalon.core.testcase.TestCase as TestCase
//import com.kms.katalon.core.testdata.TestData as TestData
//import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
//import com.kms.katalon.core.testobject.TestObject as TestObject
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
//import internal.GlobalVariable as GlobalVariable
//import org.openqa.selenium.Keys as Keys
//
//
//WebUI.comment('✅ 검색 실행')
//
//WebUI.setText(findTestObject('null'), '비비비비비비비비비비')
//
//WebUI.click(findTestObject('null'))
//
//WebUI.verifyElementPresent(findTestObject('null'), 0)
//
//WebUI.comment('✅ 검색 완료')
// 상기 스크립트는 단순 확인, 하기 스크립트는 객체 강조 확인	
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


//검색란에 ' ' 사이의 검색어 입력
WebUI.setText(findTestObject('Object Repository/Prod환경/Home/02.검색/00.검색란'), '비비비비비비비비비비')
//검색버튼 선택
WebUI.click(findTestObject('Object Repository/Prod환경/Home/02.검색/01.검색버튼'))
//검색 결과 화면 노출
WebUI.verifyElementPresent(findTestObject('Prod환경/Home/02.검색/04.검색결과 문구 없음'), 0)
//검색 결과 없는 문구 확인 (No result~)
TestObject nolist = findTestObject('Prod환경/Home/02.검색/04.검색결과 문구 없음')
HighlightElement.run(nolist)
WebUI.verifyElementPresent(nolist, 0)
// 해당 케이스 수행 완료 - console 확인용
WebUI.comment('✅ 검색 완료')




