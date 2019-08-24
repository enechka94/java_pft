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
        if(app.db().contacts().size() == 0)    {
            app.contact().create(new ContactData().withFirstname("Anna").withLastname("Skvortsova").withAddress("353 fdvgdfv sfsf")
                    .withHomeNumber("+353").withMobileNumber("131 4124").withWorkNumber("3453453453(22)")
                    .withEmail1("3434@fvfdd.dv").withEmail2("434@fdv.fdv").withEmail3("4@e.2")
                    .withBday("19").withBmonth("July").withByear("1945").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactDeletion() {
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.db().contacts();

        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.without(deletedContact)));
    }



}
