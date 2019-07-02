package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;

public class ContactCreationTest {
  private WebDriver wb;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    wb = new ChromeDriver();
    wb.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wb.get("http://localhost/addressbook/index.php");
    login("admin", "secret");
  }

  @Test
  public void testContactCreation() throws Exception {
    addNewContact();
    fillContactForm(new ContactData("Anna", "John", "Skvortsova", "anna1", "lala", "12 gfgb 45", "+2562762", "+2564572", "+3457585", "anna@mail.ru", "anna1@gmail.com", "anna2@yandex.ru", "19", "October", "1995"));
    CommitContactCreation();
    goToHomePage();

  }

  private void logout() {
    wb.findElement(By.linkText("Logout")).click();
  }

  private void goToHomePage() {
    wb.findElement(By.linkText("home page")).click();
  }

  private void CommitContactCreation() {
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]")).click();
  }

  private void fillContactForm(ContactData contactData) {
    wb.findElement(By.name("firstname")).click();
    wb.findElement(By.name("firstname")).clear();
    wb.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    wb.findElement(By.name("middlename")).click();
    wb.findElement(By.name("middlename")).clear();
    wb.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
    wb.findElement(By.name("lastname")).click();
    wb.findElement(By.name("lastname")).clear();
    wb.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    wb.findElement(By.name("nickname")).click();
    wb.findElement(By.name("nickname")).clear();
    wb.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
    wb.findElement(By.name("title")).click();
    wb.findElement(By.name("theform")).click();
    wb.findElement(By.name("company")).click();
    wb.findElement(By.name("company")).clear();
    wb.findElement(By.name("company")).sendKeys(contactData.getCompany());
    wb.findElement(By.name("address")).click();
    wb.findElement(By.name("address")).clear();
    wb.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wb.findElement(By.name("home")).click();
    wb.findElement(By.name("home")).clear();
    wb.findElement(By.name("home")).sendKeys(contactData.getHomeNumber());
    wb.findElement(By.name("mobile")).click();
    wb.findElement(By.name("mobile")).clear();
    wb.findElement(By.name("mobile")).sendKeys(contactData.getMobileNumber());
    wb.findElement(By.name("work")).click();
    wb.findElement(By.name("work")).clear();
    wb.findElement(By.name("work")).sendKeys(contactData.getWorkNumber());
    wb.findElement(By.name("email")).click();
    wb.findElement(By.name("email")).clear();
    wb.findElement(By.name("email")).sendKeys(contactData.getEmail1());
    wb.findElement(By.name("email2")).click();
    wb.findElement(By.name("email2")).clear();
    wb.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
    wb.findElement(By.name("email3")).click();
    wb.findElement(By.name("email3")).clear();
    wb.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
    wb.findElement(By.name("bday")).click();
    new Select(wb.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
    wb.findElement(By.name("bday")).click();
    wb.findElement(By.name("bmonth")).click();
    new Select(wb.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
    wb.findElement(By.name("bmonth")).click();
    wb.findElement(By.name("byear")).click();
    wb.findElement(By.name("byear")).clear();
    wb.findElement(By.name("byear")).sendKeys(contactData.getByear());
  }

  private void addNewContact() {
    wb.findElement(By.linkText("add new")).click();
  }

  private void login(String username, String password) {
    wb.findElement(By.name("user")).click();
    wb.findElement(By.name("user")).clear();
    wb.findElement(By.name("user")).sendKeys(username);
    wb.findElement(By.name("pass")).click();
    wb.findElement(By.name("pass")).clear();
    wb.findElement(By.name("pass")).sendKeys(password);
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    logout();
    wb.quit();

  }

  private boolean isElementPresent(By by) {
    try {
      wb.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wb.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


}
