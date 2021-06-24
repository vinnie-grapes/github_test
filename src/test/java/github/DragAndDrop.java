package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDrop {

    @Test
    void DragAndDropTest() {

        // Открыть страницу и проверить заголовок
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#content").shouldHave(text("Drag and Drop"));

        // Проверить, что прямоугольники действительно находятся на своих местах
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        // Перенести прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));

        // Проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
