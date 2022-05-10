package com.searchModule.Test;

import com.Tests.BaseTest;
import com.searchModule.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"searchKey"})
    public void search(String searchKey){
        SearchPage searchPage=new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(searchKey);
        searchPage.gotoVideo();
        int res=searchPage.printResult();
        Assert.assertTrue(res>20);
    }
}
