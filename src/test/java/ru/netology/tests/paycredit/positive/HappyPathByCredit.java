package ru.netology.tests.paycredit.positive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.pages.*;
import ru.netology.tests.TestUI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.netology.data.Data.*;
import static ru.netology.data.Sql.*;

public class HappyPathByCredit extends TestUI {

    private MainPage mainPage = new MainPage();
    private CardEntryForm cardEntryForm = new CardEntryForm();

    @BeforeEach
    public void clickBuyOnCredit() {
        mainPage.clickBuyOnCredit();
    }

    //Сценарий 1.

    @Test
    public void successResultIfApprovedCardsBuyForm() {
        var cardData = getCorrectlyCompletedApprovedCardForm();
        cardEntryForm.completedPaymentForm(cardData);
        cardEntryForm.waitSuccessResult();

        var expected = "APPROVED";
        var actual = getCardStatusForCreditRequest();
        assertEquals(expected, actual);

        var bankIdExpected = getBankId();
        var paymentIdActual = getPaymentId();
        assertNotNull(bankIdExpected);
        assertNotNull(paymentIdActual);
        assertEquals(bankIdExpected, paymentIdActual);
    }


    //Сценарий 2.
    @Test
    public void failResultIfDeclinedCardBuyForm() {
        var cardData = getCorrectlyCompletedDeclinedCardForm();
        cardEntryForm.completedPaymentForm(cardData);
        cardEntryForm.waitSuccessResult();

        var statusExpected = "DECLINED";
        var statusActual = getCardStatusForCreditRequest();
        assertEquals(statusExpected, statusActual);

        var bankIdExpected = getBankId();
        var paymentIdActual = getPaymentId();
        assertNotNull(bankIdExpected);
        assertNotNull(paymentIdActual);
        assertEquals(bankIdExpected, paymentIdActual);
    }

    //Сценарий 3.

    @Test
    public void successResultPayWithDoubleName() {
        var cardData = getCorrectlyFormWithDoubleSurname();
        cardEntryForm.completedPaymentForm(cardData);
        cardEntryForm.waitSuccessResult();

        var expected = "APPROVED";
        var actual = getCardStatusForCreditRequest();
        assertEquals(expected, actual);

        var bankIdExpected = getBankId();
        var paymentIdActual = getPaymentId();
        assertNotNull(bankIdExpected);
        assertNotNull(paymentIdActual);
        assertEquals(bankIdExpected, paymentIdActual);
    }
}
