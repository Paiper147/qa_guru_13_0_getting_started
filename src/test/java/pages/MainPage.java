package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    SelenideElement searchInput = $("[name=q]");

    public MainPage openMainPage(String value){
        open("https://www.google.com/");

        return this;
    }

    //two variants:
    //for successfulSearchTestWithNewPageObjectsTest()
    public MainPage typeSearchMain(String value){
        searchInput.setValue(value).pressEnter();

        return this;
    }
    //for successfulSearchTestWithFluentTest()
    public SearchPage typeSearchFluent(String value){
        searchInput.setValue(value).pressEnter();

        return new SearchPage();
    }
}
