import geb.Page
import geb.module.TextInput

class GoogleSearchPage extends Page{

    static url = "https://www.google.com/"

    static at = {
        browser.driver.currentUrl.contains(url)
    }

    static content = {
        rejectButton(required: false) { $("button div", text: contains('Reject')) }
        cookiesPopup(required: false) { $("h1", text: contains('Before you continue to Google')) }
        searchBar { $("input[type='text']") }
    }
}
