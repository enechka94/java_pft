package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase{

    @Test

    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Anna", "John", "Skvortsova", "anna1", "lala", "12 gfgb 45", "+2562762", "+2564572", "+3457585", "anna@mail.ru", "anna1@gmail.com", "anna2@yandex.ru", "19", "October", "1995", "test5"), true);
        }
        app.getNavigationHelper().goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("Angelina", "John", "Skvortsova", "anna1", "lala", "12 gfgb 45", "+2562762", "+2564572", "+0007585", "anna@mail.ru", "anna1@gmail.com", "anna2@yandex.ru", "19", "November", "1985", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
    }

}
