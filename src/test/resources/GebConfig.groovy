import geb.report.CompositeReporter
import geb.report.PageSourceReporter
import geb.report.ScreenshotReporter
import org.openqa.selenium.chrome.ChromeDriver
import geb.report.*

System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe")

driver = { new ChromeDriver() }

reporter = new MultiWindowReporter(new ScreenshotReporter())
reportsDir = "target/screenshots"

baseUrl = "http://localhost:4200"