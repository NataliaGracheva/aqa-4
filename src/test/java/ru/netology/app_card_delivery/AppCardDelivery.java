package ru.netology.app_card_delivery;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class AppCardDelivery {

    @Test
    void shouldRegisterCardDelivery() {
        open("http://localhost:9999");
        $("span[data-test-id='city'] input").setValue("Пе");
        $$("div.popup__content div").find(exactText("Пермь")).click();
        $("span[data-test-id='date'] button").click();
        String date = Integer.toString(new Date().getDate() + 3);
        $(byText(date)).click();
        $("span[data-test-id='name'] input").setValue("Пупкин Василий");
        $("span[data-test-id='phone'] input").setValue("+79000000000");
        $("label[data-test-id='agreement']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(byText("Встреча успешно забронирована на")).waitUntil(visible, 15000);
    }

}
