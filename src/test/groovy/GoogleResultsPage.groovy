import geb.Page

class GoogleResultsPage extends Page{

    static url = "https://www.google.com/search?"

    static at = {
        browser.driver.currentUrl.contains(url) && stats.displayed
    }

    static content = {
        stats(required: false) { $("#result-stats") }
    }
}
