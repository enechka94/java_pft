package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test

    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("Angelina", "John", "Skvortsova", "anna1", "lala", "12 gfgb 45", "+2562762", "+2564572", "+0007585", "anna@mail.ru", "anna1@gmail.com", "anna2@yandex.ru", "19", "November", "1985"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
    }

}
