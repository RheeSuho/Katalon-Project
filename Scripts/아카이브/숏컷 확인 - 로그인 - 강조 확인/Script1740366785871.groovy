import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import com.reusableComponents.HighlightElement // ✨ 객체 강조 기능 추가
// 🔹 로그인 정보
String url = 'https://tapas.io/account/signin?from=/'
String email = 'dkttapas00@gmail.com'
String password = 'winehouse'
String cookieFilePath = 'cookies.save' // 쿠키 저장 파일 경로

// 브라우저 이어서사용
WebUI.comment('🚀 Test 2 시작! 기존 브라우저 사용')

WebUI.callTestCase(findTestCase("Test Cases/CallTest용도/브라우저오픈"), [:], FailureHandling.STOP_ON_FAILURE)

//쿠키 파일 확인 후 자동 로그인 시도
File cookieFile = new File(cookieFilePath)

if (cookieFile.exists()) {
	WebDriver driver = DriverFactory.getWebDriver()
	try {
		FileInputStream fis = new FileInputStream(cookieFile)
		ObjectInputStream ois = new ObjectInputStream(fis)
		Set<Cookie> cookies = ((ois.readObject()) as Set<Cookie>)
		ois.close()
		fis.close()

		// 쿠키 적용
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie)
		}

		WebUI.refresh() // 🔄 페이지 새로고침하여 로그인 유지
		WebUI.comment('✅ 쿠키 로드 완료! 자동 로그인 성공')

	} catch (Exception e) {
		WebUI.comment('⚠️ 쿠키 로드 실패: ' + e.getMessage())
	}
} else {
	WebUI.comment('🆕 쿠키 없음, 로그인 진행')

	TestObject emailField = new TestObject()
	emailField.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'email\']')

	if (WebUI.waitForElementPresent(emailField, 10)) {
		WebUI.setText(emailField, email)
	} else {
		WebUI.comment('⚠️ 이메일 입력 필드 없음. JavaScript 사용')
		WebUI.executeJavaScript('document.querySelector(\'input[name="email"]\').value = arguments[0];', Arrays.asList(email))
	}
	
	TestObject passwordField = new TestObject()
	passwordField.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'password\']')

	if (WebUI.waitForElementPresent(passwordField, 10)) {
		WebUI.setText(passwordField, password)
	} else {
		WebUI.comment('⚠️ 패스워드 입력 필드 없음. JavaScript 사용')
		WebUI.executeJavaScript('document.querySelector(\'input[name="password"]\').value = arguments[0];', Arrays.asList(password))
	}
	
	TestObject loginButton = new TestObject()
	loginButton.addProperty('xpath', ConditionType.EQUALS, '//button[contains(text(), \'Log in\')]')

	WebUI.click(loginButton)
	WebUI.delay(5)

	// 로그인 후 쿠키 저장
	try {
		WebDriver driver = DriverFactory.getWebDriver()
		Set<Cookie> cookies = driver.manage().getCookies()
		FileOutputStream fos = new FileOutputStream(cookieFilePath)
		ObjectOutputStream oos = new ObjectOutputStream(fos)
		oos.writeObject(cookies)
		oos.close()
		fos.close()
		WebUI.comment('✅ 로그인 성공! 쿠키 저장 완료')

	} catch (Exception e) {
		WebUI.comment('⚠️ 쿠키 저장 실패: ' + e.getMessage())
	}
}

//숏컷 확인 (객체 강조 추가)
TestObject searchBox = findTestObject('Prod환경/Home/01.메인홈/숏컷/00.검색란')
HighlightElement.run(searchBox)
WebUI.verifyElementPresent(searchBox, 0)

TestObject logoImage = findTestObject('Prod환경/Home/01.메인홈/숏컷/01.검색버튼')
HighlightElement.run(logoImage)
WebUI.verifyElementPresent(logoImage, 0)

TestObject libraryimage = findTestObject('Prod환경/Home/01.메인홈/숏컷/03.library버튼')
HighlightElement.run(libraryimage)
WebUI.verifyElementPresent(libraryimage, 0)

TestObject inboximage = findTestObject('Prod환경/Home/01.메인홈/숏컷/04.inbox버튼')
HighlightElement.run(inboximage)
WebUI.verifyElementPresent(inboximage, 0)

TestObject profileImage = findTestObject('Prod환경/Home/01.메인홈/숏컷/05.프로필이미지')
HighlightElement.run(profileImage)
WebUI.verifyElementPresent(profileImage, 0)

TestObject publishButton = findTestObject('Prod환경/Home/01.메인홈/숏컷/06.Publish버튼')
HighlightElement.run(publishButton)
WebUI.verifyElementPresent(publishButton, 0)

WebUI.comment('✅ 로그인 확인 완료 - 검색 실행')

