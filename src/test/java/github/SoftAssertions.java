package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertions {


    @BeforeAll
    static void setUpConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    void findPageSoftAssertionsAndJUnit5Text() {
        // открыть страничку selenide
        open("https://github.com/selenide/selenide");
        $(".BorderGrid-cell").shouldHave(text("selenide.org"));
        // перейти в раздел wiki
        $(By.linkText("Wiki")).click();
        // в списке страниц есть страница Quick Start и переход по ней
        $(withText("Quick Start")).click();
        // в блоке справа есть ссылка на Custom conditions и переход по ней
        $(By.linkText("Custom conditions")).shouldBe(visible).click();
        // на странице есть Author: Olivier Grech
        $$("#wiki-body").findBy(text("Author: Olivier Grech")).shouldBe(visible);
    }
}
