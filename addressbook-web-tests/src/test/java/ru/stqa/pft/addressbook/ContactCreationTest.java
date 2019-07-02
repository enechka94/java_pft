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
  }

  @Test
  public void testContactCreation() throws Exception {
    wb.get("http://localhost/addressbook/index.php");
    wb.findElement(By.name("user")).click();
    wb.findElement(By.name("user")).clear();
    wb.findElement(By.name("user")).sendKeys("admin");
    wb.findElement(By.name("pass")).click();
    wb.findElement(By.name("pass")).clear();
    wb.findElement(By.name("pass")).sendKeys("secret");
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
    wb.findElement(By.linkText("add new")).click();
    wb.findElement(By.name("firstname")).click();
    wb.findElement(By.name("firstname")).clear();
    wb.findElement(By.name("firstname")).sendKeys("Anna");
    wb.findElement(By.name("middlename")).click();
    wb.findElement(By.name("middlename")).clear();
    wb.findElement(By.name("middlename")).sendKeys("John");
    wb.findElement(By.name("lastname")).click();
    wb.findElement(By.name("lastname")).clear();
    wb.findElement(By.name("lastname")).sendKeys("Skvortsova");
    wb.findElement(By.name("nickname")).click();
    wb.findElement(By.name("nickname")).clear();
    wb.findElement(By.name("nickname")).sendKeys("anna1");
    wb.findElement(By.name("title")).click();
    wb.findElement(By.name("theform")).click();
    wb.findElement(By.name("company")).click();
    wb.findElement(By.name("company")).clear();
    wb.findElement(By.name("company")).sendKeys("lala");
    wb.findElement(By.name("address")).click();
    wb.findElement(By.name("address")).clear();
    wb.findElement(By.name("address")).sendKeys("12 gfgb 45");
    wb.findElement(By.name("home")).click();
    wb.findElement(By.name("home")).clear();
    wb.findElement(By.name("home")).sendKeys("+2562762");
    wb.findElement(By.name("mobile")).click();
    wb.findElement(By.name("mobile")).clear();
    wb.findElement(By.name("mobile")).sendKeys("+2564572");
    wb.findElement(By.name("work")).click();
    wb.findElement(By.name("work")).clear();
    wb.findElement(By.name("work")).sendKeys("+3457585");
    wb.findElement(By.name("email")).click();
    wb.findElement(By.name("email")).clear();
    wb.findElement(By.name("email")).sendKeys("anna@mail.ru");
    wb.findElement(By.name("email2")).click();
    wb.findElement(By.name("email2")).clear();
    wb.findElement(By.name("email2")).sendKeys("anna1@gmail.com");
    wb.findElement(By.name("email3")).click();
    wb.findElement(By.name("email3")).clear();
    wb.findElement(By.name("email3")).sendKeys("anna2@yandex.ru");
    wb.findElement(By.name("bday")).click();
    new Select(wb.findElement(By.name("bday"))).selectByVisibleText("19");
    wb.findElement(By.name("bday")).click();
    wb.findElement(By.name("bmonth")).click();
    new Select(wb.findElement(By.name("bmonth"))).selectByVisibleText("October");
    wb.findElement(By.name("bmonth")).click();
    wb.findElement(By.name("byear")).click();
    wb.findElement(By.name("byear")).clear();
    wb.findElement(By.name("byear")).sendKeys("1995");
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]")).click();
    wb.findElement(By.linkText("home page")).click();
    wb.findElement(By.linkText("Logout")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
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
