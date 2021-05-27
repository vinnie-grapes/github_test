package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
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
        // перейти в раздел wiki
        $("[data-tab-item=i4wiki-tab]").click();
        // в списке страниц (Pages) есть страница SoftAssertions и перейти
        $(By.linkText("Soft assertions")).shouldBe(visible).click();
        //  проверьте что внутри есть пример кода для JUnit5
        $$("#wiki-body").findBy(text("Using JUnit5 extend test class")).shouldBe(visible);
    }
}
