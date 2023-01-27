package ru.netology.tests.paybycard.negative;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CardEntryForm;
import ru.netology.pages.MainPage;
import ru.netology.tests.TestUI;

import static ru.netology.data.Data.*;

public class EmptyCardByCard extends TestUI {
    private MainPage mainPage = new MainPage();
    private CardEntryForm cardEntryForm = new CardEntryForm();

    @BeforeEach
    public void clickBuy() {
        mainPage.clickBuy();
    }

    //Сценарий 1.
    @Test
    public void testWithEmptyCardNumberPayByCard() {
        var cardData = getFormWithEmptyCardNumber();
        cardEntryForm.completedPaymentForm(cardData);
        cardEntryForm.waitThisFieldIsRequired();
    }
}