package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().list();
    ContactData contact = new ContactData().withFirstname("Anna").withLastname("Skvortsova").
            withBday("19").withBmonth("02").withByear("1945").withEmail1("34@mail.ru");
    app.contact().create(contact, true);
    app.goTo().homePage();
    Contacts after = app.contact().list();

    Assert.assertEquals(after.size(), before.size() +1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
