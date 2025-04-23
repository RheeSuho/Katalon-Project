import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

class BrowserControl {

    @BeforeTestCase
    def beforeTestCase() {
        if (!GlobalVariable.isSuite) {
            println("[단독 실행] 브라우저 오픈")
            WebUI.openBrowser('')
			WebUI.navigateToUrl(GlobalVariable.baseUrl)
			
        }
    }

    @AfterTestCase
    def afterTestCase() {
        if (!GlobalVariable.isSuite) {
            println("[단독 실행] 브라우저 닫기")
            WebUI.closeBrowser()
        }
    }

    @BeforeTestSuite
    def beforeSuite() {
        println("[Suite 실행] 브라우저 오픈")
        WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.baseUrl)
		
    }

    @AfterTestSuite
    def afterSuite() {
        println("[Suite 실행] 브라우저 닫기")
        WebUI.closeBrowser()
        GlobalVariable.isSuite = false  // 다음 실행을 위해 초기화
    }
}
