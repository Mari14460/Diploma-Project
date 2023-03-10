package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataHelper {

    //region CARD generator
    public static String getAcceptedCard() {
        return "4444 4444 4444 4441";
    }
    public static String getDeclinedCard() {
        return "4444 4444 4444 4442";
    }
    public static String getInvalidCard() {
        return "1234 1234 1234 1234";
    }
    public static String getIncompleteCard() {
        return "1234 1234 1234 123";
    }
    //endregion

    //region MONTH generator
    public static String getValidMonth() {
        int month = new Random().nextInt(12) + 1;
        return String.format("%02d", month);
    }
    public static String getInvalidMonth00() {
        return "00";
    }
    public static String getInvalidMonth13() {
        return "13";
    }
    //endregion

    //region YEAR generator
    public static String getValidYear() {
        return LocalDate.now().plusYears(new Random().nextInt(4) + 1).format(DateTimeFormatter.ofPattern("yy"));
    }
    public static String getInvalidPreviousYear() {
        return LocalDate.now().plusYears( - 1).format(DateTimeFormatter.ofPattern("yy"));
    }
    public static String getInvalidFutureYear() {
        return LocalDate.now().plusYears( 6).format(DateTimeFormatter.ofPattern("yy"));
    }
    //endregion

    //region OWNER generator
    public static String getValidOwner() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getInvalidOwner() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getInvalidSymbolsOwner() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName() + "$#@" + " " + faker.name().lastName() + "&*(";
    }

    public static String getInvalidNumberOwner() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName() + "123" + " " + faker.name().lastName() + "456";
    }
    //endregion

    //region CVC generator
    public static String getValidCVC()  {
        int cvc = new Random().nextInt(1000);
        return String.format("%03d", cvc);
    }

    public static String getIncompleteCVC2()  {
        int cvc = new Random().nextInt(100);
        return String.format("%02d", cvc);
    }

    public static String getIncompleteCVC1()  {
        int cvc = new Random().nextInt(10);
        return String.format("%01d", cvc);
    }
    //endregion
}
