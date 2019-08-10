package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Anna"), true);
        }
    }

    @Test

    public void testContactsPhone() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditedForm = app.contact().infoFromEditedForm(contact);
        assertThat(contact.getHomeNumber(), equalTo(contactInfoFromEditedForm.getHomeNumber()));
        assertThat(contact.getMobileNumber(), equalTo(contactInfoFromEditedForm.getMobileNumber()));
        assertThat(contact.getWorkNumber(), equalTo(contactInfoFromEditedForm.getWorkNumber()));
    }

}