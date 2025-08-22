import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import internal.GlobalVariable

class BrowserControl {

	@BeforeTestCase
	def beforeTestCase() {
		println("[BeforeTestCase] GlobalVariable.isSuite: " + GlobalVariable.isSuite)

		if (!GlobalVariable.isSuite) {
			println("[단독 실행] 브라우저 오픈")
			WebUI.openBrowser('')

			// ✅ URL 강제 지정
			String url = 'https://tapas.io'
			WebUI.navigateToUrl(url)
			WebUI.waitForPageLoad(10)
			WebUI.verifyMatch(WebUI.getUrl(), url, false)

			WebUI.delay(2)
		}
	}

	@AfterTestCase
	def afterTestCase() {
		println("[AfterTestCase] GlobalVariable.isSuite: " + GlobalVariable.isSuite)
		if (!GlobalVariable.isSuite) {
			println("[단독 실행] 브라우저 닫기 시도")
			closeBrowserIfOpen("AfterTestCase")
		}
	}

	@BeforeTestSuite
	def beforeSuite() {
		println("[Suite 실행] 브라우저 오픈")
		GlobalVariable.isSuite = true  // ✅ 여기로 이동 (기존 SetSuiteFlag 역할 대체)

		WebUI.openBrowser('')

		// ✅ URL 강제 지정
		String url = 'https://tapas.io'
		WebUI.navigateToUrl(url)
		WebUI.waitForPageLoad(10)
		WebUI.verifyMatch(WebUI.getUrl(), url, false)
}

	@AfterTestSuite
	def afterSuite() {
		println("[Suite 실행] 브라우저 닫기 시도")
		closeBrowserIfOpen("AfterTestSuite")
		GlobalVariable.isSuite = false
	}

	// ✅ 핵심 로직: 열려 있는 경우에만 닫기
	private void closeBrowserIfOpen(String context) {
		try {
			WebDriver driver = DriverFactory.getWebDriver()
			if (driver != null && !driver.getWindowHandles().isEmpty()) {
				WebUI.closeBrowser()
				println("[$context] 브라우저 정상 종료 완료")
			} else {
				println("[$context] 브라우저가 이미 닫혀 있거나 열려 있지 않음")
			}
		} catch (Exception e) {
			println("[$context] 브라우저 종료 실패: ${e.message}")
		}
	}
}