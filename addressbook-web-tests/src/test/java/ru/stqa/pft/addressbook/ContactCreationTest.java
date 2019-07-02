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
    login();
  }

  @Test
  public void testContactCreation() throws Exception {

    addNewContact();
    fillFirstName();
    fillMiddleName();
    fillLastName();
    fillNickname();
    fillCompanyName();
    fillAddress();
    fillHomePhoneNumber();
    fillMobileNumber();
    fillWorkPhoneNumber();
    fillEmail1();
    fillEmail2();
    fillEmail3();
    chooseBday();
    chooseBmonth();
    chooseByear();
    clickEnter();
    goToHomePage();

  }

  private void logout() {
    wb.findElement(By.linkText("Logout")).click();
  }

  private void goToHomePage() {
    wb.findElement(By.linkText("home page")).click();
  }

  private void clickEnter() {
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]")).click();
  }

  private void chooseByear() {
    wb.findElement(By.name("byear")).click();
    wb.findElement(By.name("byear")).clear();
    wb.findElement(By.name("byear")).sendKeys("1995");
  }

  private void chooseBmonth() {
    wb.findElement(By.name("bmonth")).click();
    new Select(wb.findElement(By.name("bmonth"))).selectByVisibleText("October");
    wb.findElement(By.name("bmonth")).click();
  }

  private void chooseBday() {
    wb.findElement(By.name("bday")).click();
    new Select(wb.findElement(By.name("bday"))).selectByVisibleText("19");
    wb.findElement(By.name("bday")).click();
  }

  private void fillEmail3() {
    wb.findElement(By.name("email3")).click();
    wb.findElement(By.name("email3")).clear();
    wb.findElement(By.name("email3")).sendKeys("anna2@yandex.ru");
  }

  private void fillEmail2() {
    wb.findElement(By.name("email2")).click();
    wb.findElement(By.name("email2")).clear();
    wb.findElement(By.name("email2")).sendKeys("anna1@gmail.com");
  }

  private void fillEmail1() {
    wb.findElement(By.name("email")).click();
    wb.findElement(By.name("email")).clear();
    wb.findElement(By.name("email")).sendKeys("anna@mail.ru");
  }

  private void fillWorkPhoneNumber() {
    wb.findElement(By.name("work")).click();
    wb.findElement(By.name("work")).clear();
    wb.findElement(By.name("work")).sendKeys("+3457585");
  }

  private void fillMobileNumber() {
    wb.findElement(By.name("mobile")).click();
    wb.findElement(By.name("mobile")).clear();
    wb.findElement(By.name("mobile")).sendKeys("+2564572");
  }

  private void fillHomePhoneNumber() {
    wb.findElement(By.name("home")).click();
    wb.findElement(By.name("home")).clear();
    wb.findElement(By.name("home")).sendKeys("+2562762");
  }

  private void fillAddress() {
    wb.findElement(By.name("address")).click();
    wb.findElement(By.name("address")).clear();
    wb.findElement(By.name("address")).sendKeys("12 gfgb 45");
  }

  private void fillCompanyName() {
    wb.findElement(By.name("company")).click();
    wb.findElement(By.name("company")).clear();
    wb.findElement(By.name("company")).sendKeys("lala");
  }

  private void fillNickname() {
    wb.findElement(By.name("nickname")).click();
    wb.findElement(By.name("nickname")).clear();
    wb.findElement(By.name("nickname")).sendKeys("anna1");
  }

  private void fillLastName() {
    wb.findElement(By.name("lastname")).click();
    wb.findElement(By.name("lastname")).clear();
    wb.findElement(By.name("lastname")).sendKeys("Skvortsova");
  }

  private void fillMiddleName() {
    wb.findElement(By.name("middlename")).click();
    wb.findElement(By.name("middlename")).clear();
    wb.findElement(By.name("middlename")).sendKeys("John");
  }

  private void fillFirstName() {
    wb.findElement(By.name("firstname")).click();
    wb.findElement(By.name("firstname")).clear();
    wb.findElement(By.name("firstname")).sendKeys("Anna");
  }

  private void addNewContact() {
    wb.findElement(By.linkText("add new")).click();
  }

  private void login() {
    wb.findElement(By.name("user")).click();
    wb.findElement(By.name("user")).clear();
    wb.findElement(By.name("user")).sendKeys("admin");
    wb.findElement(By.name("pass")).click();
    wb.findElement(By.name("pass")).clear();
    wb.findElement(By.name("pass")).sendKeys("secret");
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
