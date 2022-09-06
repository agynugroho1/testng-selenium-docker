package duckduckgo.search.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import search.duckgo.searchPage;
import tests.BaseTest;

public class DuckGoSearchTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void searchContent(String keyword) {
        searchPage spage = new searchPage(driver);
        spage.goTo();
        spage.doSearch(keyword);
        spage.goToVideosPage();
        int size = spage.printResult();
        Assert.assertTrue(size > 0);
    }
}
