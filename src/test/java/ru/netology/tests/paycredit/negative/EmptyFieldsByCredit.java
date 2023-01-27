package ru.netology.tests.paycredit.negative;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CardEntryForm;
import ru.netology.pages.MainPage;
import ru.netology.tests.TestUI;

import static com.codeborne.selenide.Selenide.$$;
import static ru.netology.data.Data.getFormWithAllEmptyFields;

public class EmptyFieldsByCredit extends TestUI {
    private MainPage mainPage = new MainPage();
    private CardEntryForm cardEntryForm = new CardEntryForm();

    @BeforeEach
    public void clickBuyOnCredit() {
        mainPage.clickBuyOnCredit();
    }

    @Test

    //Сценарий 2.

    public void testWithEmptyAllFieldsPayByCredit() {
        var cardData = getFormWithAllEmptyFields();
        cardEntryForm.completedPaymentForm(cardData);
        final ElementsCollection emptyField = $$(".input__sub");
        final SelenideElement cardNumberField = emptyField.get(1);
        final SelenideElement monthField = emptyField.get(2);
        final SelenideElement yearField = emptyField.get(3);
        final SelenideElement holderField = emptyField.get(4);
        final SelenideElement cvcField = emptyField.get(5);
        cardNumberField.shouldHave(Condition.text("Поле обязательно для заполнения"));
        monthField.shouldHave(Condition.text("Поле обязательно для заполнения"));
        yearField.shouldBe(Condition.text("Поле обязательно для заполнения"));
        holderField.shouldBe(Condition.text("Поле обязательно для заполнения"));
        cvcField.shouldBe(Condition.visible.text("Поле обязательно для заполнения"));
    }
}