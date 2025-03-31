import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.io.*
import java.util.Arrays
import java.util.Set
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// 🔹 로그인 정보
String url = 'https://tapas.io/account/signin?from=/'  // QA 환경 URL
String email = 'dkttapas00@gmail.com'
String password = 'winehouse'
String cookieFilePath = 'cookies.save' // 쿠키 저장 파일 경로


// 🔹 브라우저 열기
WebUI.openBrowser('')
WebUI.navigateToUrl(url)

WebDriver driver = DriverFactory.getWebDriver()

// 🔹 쿠키 파일이 존재하면 불러오기
File cookieFile = new File(cookieFilePath)

if (cookieFile.exists()) {
    try {
        FileInputStream fis = new FileInputStream(cookieFile)
        ObjectInputStream ois = new ObjectInputStream(fis)
        Set<Cookie> cookies = (Set<Cookie>) ois.readObject()
        ois.close()
        fis.close()

        // 쿠키 추가
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie)
        }

        // 쿠키 적용 후 URL 다시 로드
        driver.get(url)

        WebUI.comment('✅ 쿠키 로드 완료! 자동 로그인 성공 시도')

        // 로그인 성공 여부 확인 (예: 프로필 아이콘이 나타나는지 체크)
        TestObject profileIcon = new TestObject()
        profileIcon.addProperty('xpath', ConditionType.EQUALS, '//img[contains(@alt, "profile")]')

        if (WebUI.waitForElementPresent(profileIcon, 5)) {
            WebUI.comment('✅ 자동 로그인 성공!')
            return
        } else {
            WebUI.comment('⚠️ 자동 로그인 실패! 로그인 페이지 유지됨.')
        }
    }
    catch (Exception e) {
        WebUI.comment('⚠️ 쿠키 로드 실패: ' + e.getMessage())
    }
}

// 🔹 쿠키가 없거나 자동 로그인 실패 시, 로그인 절차 진행
WebUI.comment('🆕 쿠키 없음 또는 자동 로그인 실패, 로그인 진행')

TestObject emailField = new TestObject()
emailField.addProperty('xpath', ConditionType.EQUALS, '//input[@name="email"]')

if (WebUI.waitForElementPresent(emailField, 10)) {
    WebUI.setText(emailField, email)
} else {
    WebUI.comment('⚠️ 이메일 입력 필드 없음. JavaScript 사용')
    WebUI.executeJavaScript('document.querySelector("input[name=\'email\']").value = arguments[0];', Arrays.asList(email))
}

TestObject passwordField = new TestObject()
passwordField.addProperty('xpath', ConditionType.EQUALS, '//input[@name="password"]')

if (WebUI.waitForElementPresent(passwordField, 10)) {
    WebUI.setText(passwordField, password)
} else {
    WebUI.comment('⚠️ 패스워드 입력 필드 없음. JavaScript 사용')
    WebUI.executeJavaScript('document.querySelector("input[name=\'password\']").value = arguments[0];', Arrays.asList(password))
}

TestObject loginButton = new TestObject()
loginButton.addProperty('xpath', ConditionType.EQUALS, '//button[contains(text(), "Log in")]')

if (WebUI.waitForElementClickable(loginButton, 10)) {
    try {
        WebUI.comment('🔹 로그인 버튼 클릭')
        WebUI.click(loginButton)
    } catch (Exception e) {
        WebUI.comment('⚠️ 기본 클릭 실패, JavaScript 사용')
        WebUI.executeJavaScript('document.querySelector("button[type=\'submit\']").click();', null)
    }
} else {
    WebUI.comment('⚠️ 로그인 버튼을 찾을 수 없음')
}

WebUI.delay(5)

// 🔹 로그인 성공 여부 확인 (예: 프로필 아이콘이 나타나는지 체크)
TestObject profileIcon = new TestObject()
profileIcon.addProperty('xpath', ConditionType.EQUALS, '//img[contains(@alt, "profile")]')

if (WebUI.waitForElementPresent(profileIcon, 10)) {
    WebUI.comment('✅ 로그인 성공! 쿠키 저장 진행')

    // 🔹 로그인 성공 후 쿠키 저장
    try {
        Set<Cookie> cookies = driver.manage().getCookies()
        FileOutputStream fos = new FileOutputStream(cookieFilePath)
        ObjectOutputStream oos = new ObjectOutputStream(fos)
        oos.writeObject(cookies)
        oos.close()
        fos.close()

        WebUI.comment('✅ 쿠키 저장 완료')
    }
    catch (Exception e) {
        WebUI.comment('⚠️ 쿠키 저장 실패: ' + e.getMessage())
    }
} else {
    WebUI.comment('❌ 로그인 실패! 아이디/비밀번호 확인 필요')
}
