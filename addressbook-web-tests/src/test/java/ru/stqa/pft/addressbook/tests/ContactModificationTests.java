package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

    @Test

    public void testContactModification() {
        app.goTo().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Anna", "John", "Skvortsova", "anna1", "lala", "12 gfgb 45", "+2562762", "+2564572", "+3457585", "anna@mail.ru", "anna1@gmail.com", "anna2@yandex.ru", "19", "October", "1995", "test5"), true);
        }
        app.goTo().goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        //app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().editContact(before.size()-1);
        ContactData contact = new ContactData("Angelina", "John", "Skvortsova", "anna1", "lala", "12 gfgb 45", "+2562762", "+2564572", "+0007585", "anna@mail.ru", "anna1@gmail.com", "anna2@yandex.ru", "19", "November", "1985", null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.goTo().goToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
