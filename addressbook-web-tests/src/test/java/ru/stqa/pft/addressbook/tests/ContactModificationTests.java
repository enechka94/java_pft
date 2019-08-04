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
        app.contact().create(new ContactData().withFirstname("Anna"), true);
    }
}

    @Test
    public void testContactModification() {
        app.goTo().homePage();
        ContactData contact = new ContactData().withFirstname("Anna").withLastname("Skvortsova").
                withBday("19").withBmonth("02").withByear("1945").withEmail1("34@mail.ru");
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
