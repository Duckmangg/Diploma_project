package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@NoArgsConstructor
public class Data {

    public static Faker faker = new Faker(new Locale("en"));

    public static String generateMonth() {
        int month = faker.number().numberBetween(0, 13);
        String date = LocalDate.now().plusMonths(month).format(DateTimeFormatter.ofPattern("MM"));
        return date;
    }

    public static String generateYear() {
        int year = faker.number().numberBetween(1, 6);
        String date = LocalDate.now().plusYears(year).format(DateTimeFormatter.ofPattern("yy"));
        return date;
    }

    public static String getAppruveCardNumber() {
        String card = "4444444444444441";
        return card;
    }

    public static String getDeclineCardNumber() {
        String card = "4444444444444442";
        return card;
    }

    public static String getCorrectName() {
        String name = "Kirilov Kirill";
        return name;
    }

    public static String getCorrectCvc() {
        String cvc = "222";
        return cvc;
    }

    @Value
    public static class CardData {
        String number;
        String month;
        String year;
        String holder;
        String cvc;

    }
    //Позитивные Сценарии.
    //Сценарий 1. Заявка на покупку со всеми валидными значениями.

    public static CardData getCorrectlyCompletedApprovedCardForm() {
        return new CardData(getAppruveCardNumber(), generateMonth(), generateYear(), getCorrectName(), getCorrectCvc());
    }


    //Сценарий 2. Указан не действующий номер карты.
    public static CardData getCorrectlyCompletedDeclinedCardForm() {
        return new CardData(getDeclineCardNumber(), generateMonth(), generateYear(), getCorrectName(), getCorrectCvc());
    }

    //Сценарий 3. Двойная фамилия.
    public static CardData getCorrectlyFormWithDoubleSurname() {
        return new CardData(getDeclineCardNumber(), generateMonth(), generateYear(), "Kirilov-ivanov Kirill", getCorrectCvc());
    }


    //Неагтивные сценарии.
    //Сценарий 1. Отправить заявку с несуществующим номером карты.
    public static CardData getFormWithIncorrectCardNumber() {
        return new CardData("4444 4444 4444 4443", generateMonth(), generateYear(), getCorrectName(), getCorrectCvc());
    }

    //Сценарий 2. Пустые поля
    public static CardData getFormWithAllEmptyFields() {
        return new CardData("", "", "", "", "");
    }


    //Сценарий 3.Отправить заявку с пустым полем "Номер карты".
    public static CardData getFormWithEmptyCardNumber() {
        return new CardData("", generateMonth(), generateYear(), getCorrectName(), getCorrectCvc());
    }

    //Сценарий 4.Отправить заявку с пустым полем "Месяц".
    public static CardData getFormWithEmptyMonth() {
        return new CardData(getAppruveCardNumber(), "", generateYear(), getCorrectName(), getCorrectCvc());
    }

    //Сценарий 5. Отправить заявку с незаполненным полем "год".
    public static CardData getFormWithEmptyYear() {
        return new CardData(getAppruveCardNumber(), generateMonth(), "", getCorrectName(), getCorrectCvc());
    }

    //Сценарий 6. Отправить заявку с пустым полем "Владелец".
    public static CardData getFormWithEmptyName() {
        return new CardData(getAppruveCardNumber(), generateMonth(), generateYear(), "", getCorrectCvc());
    }

    //Сценарий 7. Отправить заявку с пустым полем "CVC/CVV".
    public static CardData getFormWithEmptyCvc() {
        return new CardData(getAppruveCardNumber(), generateMonth(), generateYear(), getCorrectName(), "");
    }

    //Сценарий 8. Отправить заявку с недостаточным количеством цифр в номере карты.
    public static CardData getFormWithNotEnoughNumbersInCard() {
        return new CardData("4444 4444 4444 44", generateMonth(), generateYear(), getCorrectName(), getCorrectCvc());
    }

    //Сценарий 9. Указание просроченного срока действия карты.
    public static CardData getFormWithExpiredYearCard() {
        return new CardData(getAppruveCardNumber(), generateMonth(), "15", getCorrectName(), getCorrectCvc());
    }

    //Сценарий 10. Невалидный месяц действия карты.
    public static CardData getFormWithInvalidMonth() {
        return new CardData(getAppruveCardNumber(), "13", generateYear(), getCorrectName(), getCorrectCvc());
    }

    //Сценарий 11. Невалидный год действия карты.
    public static CardData getFormWithInvalidYear() {
        return new CardData(getAppruveCardNumber(), generateMonth(), "99", getCorrectName(), getCorrectCvc());
    }

    //Сценарий 12. Отправить заявку некорректным заполнением поля "Владелец"(цифрами).
    public static CardData getFormWithNumbersInTheName() {
        return new CardData(getAppruveCardNumber(), generateMonth(), generateYear(), "2012 2016", getCorrectCvc());
    }

    //Сценарий 13. Указание владельца карты на кириллице.
    public static CardData getFormWithNameInCyrillic() {
        return new CardData(getAppruveCardNumber(), generateMonth(), generateYear(), "Кириллов Кирилл", getCorrectCvc());
    }

    //Сценарий 14. Отправить заявку с некорректным значением в поле "Год"(одна цифра).
    public static CardData getFormWithOneNumberInYear() {
        return new CardData(getAppruveCardNumber(), generateMonth(), "2", getCorrectName(), getCorrectCvc());
    }

    //Сценарий 15. Отправить заявку с невалидным значением в поле: "CVC/CVV"(одна цифра).
    public static CardData getFormWithOneNumberInCvc() {
        return new CardData(getAppruveCardNumber(), generateMonth(), generateYear(), getCorrectName(), "2");
    }

    //Сценарий 16. Отправить заявку с невалидным значением в поле "Владелец" (заполнение поля 1 буква).
    public static CardData getFormWithOneLetterInName() {
        return new CardData(getAppruveCardNumber(), generateMonth(), generateYear(), "K", getCorrectCvc());
    }

    //Сценарий 17. Отправить заявку с невалидным значением в поле: "CVC/CVV"(символы).
    public static CardData getFormWithSymbolInCvc() {
        return new CardData(getAppruveCardNumber(), generateMonth(), generateYear(), getCorrectName(), "###");
    }
}
