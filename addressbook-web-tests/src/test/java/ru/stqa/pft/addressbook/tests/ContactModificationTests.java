package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.Comparator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

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
    public void testContactModification() {
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        File photo = new File("src/test/resources/1556232387135-31.jpg");
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Inga").withLastname("Skvortsova")
                .withPhoto(photo).withBday("19").withAddress("353 fdvgdfv sfsf")
                .withHomeNumber("+353").withMobileNumber("131 4124").withWorkNumber("3453453453(22)")
                .withEmail1("3434@fvfdd.dv").withEmail2("434@fdv.fdv").withEmail3("4@e.2")
                .withBday("19").withBmonth("June").withByear("1945");
        app.contact().modify(contact);
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.withAdded(contact).without(modifiedContact)));
    }



}
