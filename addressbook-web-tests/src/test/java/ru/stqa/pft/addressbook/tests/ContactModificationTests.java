package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
     app.goTo().homePage();
        if(app.contact().list().size() == 0)    {
        app.contact().create(new ContactData("Anna", "John", "Skvortsova", "anna1", "lala", "12 gfgb 45", "+2562762", "+2564572", "+3457585", "anna@mail.ru", "anna1@gmail.com", "anna2@yandex.ru", "19", "October", "1995", "test5"), true);
    }
}

    @Test
    public void testContactModification() {
        app.goTo().homePage();
        ContactData contact = new ContactData("Angelina", "John", "Skvortsova", "anna1", "lala", "12 gfgb 45", "+2562762", "+2564572", "+0007585", "anna@mail.ru", "anna1@gmail.com", "anna2@yandex.ru", "19", "November", "1985", null);
        Contacts before = app.contact().list();
        int index = before.size() - 1;
        app.contact().modify(contact, index);
        Contacts after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        //before.sort(byId);
        //after.sort(byId);
        Assert.assertEquals(before, after);
    }



}
