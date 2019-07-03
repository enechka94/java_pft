package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ChromeDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void goToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }
}
