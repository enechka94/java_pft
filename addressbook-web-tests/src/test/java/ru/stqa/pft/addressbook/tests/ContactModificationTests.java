package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        ContactData contact = new ContactData().withFirstname("Svetlana").withLastname("Skvortsova").
                withBday("19").withBmonth("June").withByear("1945");
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        int index = before.size() - 1;
        app.contact().modify(contact, index);
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.withAdded(modifiedContact).without(contact)));
    }



}
