import geb.Page

class SandboxPage extends Page {

    static url = "/"
    static at = {
        browser.driver.currentUrl.contains(url)
    }

    static content = {
        githubLink(required: true) { $("body > app-root > footer > p:nth-child(5) > a:nth-child(1)") }
    }
}
