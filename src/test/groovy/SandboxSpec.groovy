import geb.spock.GebReportingSpec

import java.lang.reflect.InvocationTargetException
import java.nio.file.Paths

class SandboxSpec extends GebReportingSpec {

    def <T> T withNewWindow(Map options, Closure windowOpeningBlock, Closure<T> block) {
        windowOpeningBlock = createClosureWithCatch(windowOpeningBlock)
        block = createClosureWithCatch(block)

        return browser.withNewWindow(options, windowOpeningBlock, block) as T
    }

    private <T> Closure<T> createClosureWithCatch(Closure closure) {
        return {
            try {
                closure.call()
            } catch(Throwable e) {
                report()
                throw e
            }
        } as Closure<T>
    }

    def "1 - Test"() {
        when: "PIHguiubj"
            to SandboxPage

        then: "O{p98gfygiuoh"
            at SandboxPage

        when: "PUiyucvybiuoh"
            withNewWindow({ githubtLink.click() }, close: true) {
                then: "Things"
                    at GithubPage

                when: "Click dropdown"
                    branchDropdown.click()

                then: "Dropdown comes"
                    assert branchMenu.displayed

                when: "Click"
                    branchDropdown.click()

                then: "Dropdown goes"
                    assert branchMenu.displayed == false

                when: "Click dropdown"
                    branchDropdown.click()

                then: "Dropdown comes"
                    waitFor { branchMenu.displayed }

                when: "Click"
                    branchDropdown.click()

                then: "Dropdown goes"
                    assert branchMenu.displayed == false
            }

        then:
            true
    }

}
