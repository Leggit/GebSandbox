import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys

class GoogleSpec extends GebReportingSpec {

    def setupSpec() {
        println("Runs once before all the tests in the spec")
    }

    def setup() {
        println("Runs before each test")
    }

    def cleanup() {
        println("Runs after each test")
    }

    def cleanupSpec() {
        println("Runs once after all the tests in the spec")
    }

    def "1 - Google search"() {
        given:
            println("Some pre conditions")

        when: "We go to google"
            to GoogleSearchPage

        then: "A search bar is displayed"
            at GoogleSearchPage

        when: "Click reject button"
            if(rejectButton.displayed && cookiesPopup.displayed)
                rejectButton.click()

        then: "Popup should disappear"
            assert cookiesPopup.displayed == false

        when: "Search for something"
            searchBar.value("Hello World")

        then: "The search bar contains the input"
            searchBar.value() == "Hello World"

        when: "The user presses enter"
            searchBar << Keys.chord(Keys.ENTER)

        then: "Search completes"
            at GoogleResultsPage

        cleanup:
            println("Cleaning up")
    }
}
