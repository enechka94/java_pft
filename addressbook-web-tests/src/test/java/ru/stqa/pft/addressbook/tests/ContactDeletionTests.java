package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test

    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Anna", "John", "Skvortsova", "anna1", "lala", "12 gfgb 45", "+2562762", "+2564572", "+3457585", "anna@mail.ru", "anna1@gmail.com", "anna2@yandex.ru", "19", "October", "1995", "test5"), true);
        }
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().submitDeletion();
        app.getNavigationHelper().goToHomePage();
    }
}
