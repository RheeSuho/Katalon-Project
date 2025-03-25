import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import java.util.Arrays as Arrays

// 로그인 정보 설정
String email = 'dkttapas00@gmail.com'

String url = 'https://tapas.io/account/signin?from=/'

String password = 'winehouse'

// 브라우저 열기
WebUI.openBrowser('')

//로그인 페이지로 이동
WebUI.navigateToUrl(url)

// 이메일 입력 필드 확인 후 입력
TestObject emailField = new TestObject()

emailField.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'email\']')

if (WebUI.waitForElementPresent(emailField, 10)) {
    WebUI.setText(emailField, email)
} else {
    WebUI.comment('⚠️ 이메일 입력 필드를 찾을 수 없음. JavaScript로 입력 시도')

    WebUI.executeJavaScript('document.querySelector(\'input[name="email"]\').value = arguments[0];', Arrays.asList(email))
}

// 패스워드 확인 후 입력
TestObject passwordField = new TestObject()

passwordField.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'password\']')

if (WebUI.waitForElementPresent(passwordField, 10)) {
    WebUI.setText(passwordField, password)
} else {
    WebUI.comment('⚠️ 이메일 입력 필드를 찾을 수 없음. JavaScript로 입력 시도')

    WebUI.executeJavaScript('document.querySelector(\'input[name="password"]\').value = arguments[0];', Arrays.asList(password))
}

// 로그인 버튼 클릭
TestObject loginButton = new TestObject()

loginButton.addProperty('xpath', ConditionType.EQUALS, '//button[contains(text(), \'Log in\')]')

WebUI.click(loginButton)

