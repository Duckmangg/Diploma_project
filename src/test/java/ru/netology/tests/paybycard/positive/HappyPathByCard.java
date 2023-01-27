package ru.netology.tests.paybycard.positive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.pages.*;
import ru.netology.tests.TestUI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.netology.data.Data.*;
import static ru.netology.data.Sql.*;

public class HappyPathByCard extends TestUI {
    private MainPage mainPage = new MainPage();
    private CardEntryForm cardEntryForm = new CardEntryForm();

    @BeforeEach
    public void clickBuy() {
        mainPage.clickBuy();
    }

    //Сценарий 1.

    @Test
    public void successResultIfApprovedCardsBuyForm() {
        var cardData = getCorrectlyCompletedApprovedCardForm();
        cardEntryForm.completedPaymentForm(cardData);
        cardEntryForm.waitSuccessResult();

        var statusExpected = "APPROVED";
        var statusActual = getCardStatusForPayment();
        assertEquals(statusExpected, statusActual);

        var expectedAmount = "45000";
        var actualAmount = getAmountPayment();
        assertEquals(expectedAmount, actualAmount);

        var expectedId = getTransactionId();
        var actualId = getPaymentId();
        assertNotNull(actualId);
        assertNotNull(expectedId);
        assertEquals(expectedId, actualId);
    }


    //Сценарий 2.
    @Test
    public void failResultIfDeclinedCardBuyForm() {
        var cardData = getCorrectlyCompletedDeclinedCardForm();
        cardEntryForm.completedPaymentForm(cardData);
        cardEntryForm.waitSuccessResult();

        var statusExpected = "DECLINED";
        var statusActual = getCardStatusForPayment();
        assertEquals(statusExpected, statusActual);

        var expectedId = getBankId();
        var actualId = getPaymentId();
        assertNotNull(expectedId);
        assertNotNull(actualId);
        assertEquals(expectedId, actualId);
    }

    //Сценарий .

    @Test
    public void successResultPayWithDoubleName() {
        var cardData = getCorrectlyFormWithDoubleSurname();
        cardEntryForm.completedPaymentForm(cardData);
        cardEntryForm.waitSuccessResult();

        var statusExpected = "APPROVED";
        var statusActual = getCardStatusForPayment();
        assertEquals(statusExpected, statusActual);

        var expectedAmount = "45000";
        var actualAmount = getAmountPayment();
        assertEquals(expectedAmount, actualAmount);

        var expectedId = getTransactionId();
        var actualId = getPaymentId();
        assertNotNull(actualId);
        assertNotNull(expectedId);
        assertEquals(expectedId, actualId);
    }

}
