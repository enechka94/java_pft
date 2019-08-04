package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {

    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Anna").withLastname("Skvortsova").
            withBday("19").withBmonth("July").withByear("1945").withGroup("test1");
    app.contact().create(contact, true);
    app.goTo().homePage();
    Contacts after = app.contact().all();

    assertThat(after.size(), equalTo(before.size() +1));
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }

}
