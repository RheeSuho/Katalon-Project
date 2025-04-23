import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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
			println("[단독 실행] 브라우저 닫기")
			WebUI.closeBrowser()
		}
	}

	@BeforeTestSuite
	def beforeSuite() {
		println("[Suite 실행] 브라우저 오픈")
		WebUI.openBrowser('')

		// ✅ URL 강제 지정
		String url = 'https://tapas.io'
		WebUI.navigateToUrl(url)
		WebUI.waitForPageLoad(10)
		WebUI.verifyMatch(WebUI.getUrl(), url, false)
	}

	@AfterTestSuite
	def afterSuite() {
		println("[Suite 실행] 브라우저 닫기")
		WebUI.closeBrowser()
		GlobalVariable.isSuite = false  // 다음 단독 실행 위해 초기화
	}
}
