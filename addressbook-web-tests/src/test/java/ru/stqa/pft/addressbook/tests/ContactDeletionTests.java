package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if(app.contact().list().size() == 0)    {
            app.contact().create(new ContactData().withFirstname("Viktoria"), true);
        }
    }

    @Test
    public void testContactDeletion() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        int index = before.size() - 1;
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(index);
        Contacts after = app.contact().all();

        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.without(deletedContact)));
    }


}
