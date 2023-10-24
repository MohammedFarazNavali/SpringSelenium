package com.navali.spring_selenium.page.google;

import com.navali.spring_selenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GooglePage extends Base {

    @Value("${application.url}")
    private String url;

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResults;

    public void goTo() {
        this.driver.get(url);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResult getSearchResults() {
        return searchResults;
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }

    public void close(){
        this.driver.quit();
    }
}
