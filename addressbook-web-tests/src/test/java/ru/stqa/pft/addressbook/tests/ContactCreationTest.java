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
    ContactData contact = new ContactData().withFirstname("Anna").withLastname("Skvortsova").withAddress("353 fdvgdfv sfsf")
      .withHomeNumber("+353").withMobileNumber("131 4124").withWorkNumber("3453453453(22)")
            .withEmail1("3434@fvfdd.dv").withEmail2("434@fdv.fdv").withEmail3("4@e.2")
            .withBday("19").withBmonth("July").withByear("1945").withGroup("test1");
    app.contact().create(contact, true);
    app.goTo().homePage();
    Contacts after = app.contact().all();
    app.goTo().homePage();
    assertThat(after.size(), equalTo(before.size() +1));
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    app.goTo().homePage();

  }

}
