import geb.Page

class GithubPage extends Page{

    static url = "https://github.com/"

    static at = {
        browser.driver.currentUrl.contains(url)
    }

    static content = {
        aboutText(required: false) { $("#repo-content-pjax-container > div > div.gutter-condensed.gutter-lg.flex-column.flex-md-row.d-flex > div.flex-shrink-0.col-12.col-md-3 > div > div.BorderGrid-row.hide-sm.hide-md > div > p") }
        branchDropdown(required: false) { $("#branch-select-menu > summary") }
        branchMenu(required: false) { $("#branch-select-menu > div > div") }
    }
}
