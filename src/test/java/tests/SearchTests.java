package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {

    @Test
    void successfulSearchTest() {
        //открыть Chrome
        open("https://www.google.com/");

        //вписать в строке поиска "selenide"
        $("[name=q]").setValue("selenide").pressEnter();

        //проверить, что появился "selenide" в результатах поиска
        $("#search").shouldHave(text("https://ru.selenide.org"));
    }

    @Test
    void successfulSearchTestWithNewPageObjectsTest() {

        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();

        //открыть Chrome
        mainPage.openMainPage("https://www.google.com/")
                .typeSearchMain("selenide");

        //проверить, что появился "selenide" в результатах поиска
        searchPage.checkResult("https://ru.selenide.org");
    }

    @Test
    void successfulSearchTestWithFluentTest() {

        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();

        //открыть Chrome
        mainPage.openMainPage("https://www.google.com/")
                .typeSearchFluent("selenide")
                .checkResult("https://ru.selenide.org");
    }
}
