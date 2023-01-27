package ru.netology.tests.paycredit.negative;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CardEntryForm;
import ru.netology.pages.MainPage;
import ru.netology.tests.TestUI;

import static ru.netology.data.Data.getFormWithEmptyMonth;

public class EmptyMonthByCredit extends TestUI {
    private MainPage mainPage = new MainPage();
    private CardEntryForm cardEntryForm = new CardEntryForm();

    @BeforeEach
    public void clickBuyOnCredit() {
        mainPage.clickBuyOnCredit();
    }

    //Сценарий 1.
    @Test
    public void testWithEmptyMonthPayByCredit() {
        var cardData = getFormWithEmptyMonth();
        cardEntryForm.completedPaymentForm(cardData);
        cardEntryForm.waitThisFieldIsRequired();
    }
}