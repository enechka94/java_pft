package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactInGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            File photo = new File("src/test/resources/1556232387135-31.jpg");
            app.contact().create(new ContactData().withFirstname("Anna").withLastname("Skvortsova")
                    .withPhoto(photo).withAddress("353 fdvgdfv sfsf")
                    .withHomeNumber("+353").withMobileNumber("131 4124").withWorkNumber("3453453453(22)")
                    .withEmail1("3434@fvfdd.dv").withEmail2("434@fdv.fdv").withEmail3("4@e.2")
                    .withBday("19").withBmonth("July").withByear("1945"), true);
        }

        app.goTo().groupPage();
        if (app.db().groups().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testContactAddToGroup() {
        Contacts contacts = app.db().contacts();
        ContactData contactToAdd = contacts.iterator().next();
        Groups groups = app.db().groups();
        GroupData groupToAdd = groups.iterator().next();
        Groups contactInGroupsBefore = contactToAdd.getGroups();
        app.goTo().homePage();
        app.contact().addToGroup(contactToAdd, groupToAdd);
        Groups contactInGroupsAfter = contactToAdd.getGroups();
        assertThat(contactInGroupsAfter, equalTo(contactInGroupsBefore));

    }
}