package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper  extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        wd.findElement(By.xpath("//input[@value='Enter']")).click();
    }

    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), "Иван");
        type(By.name("middlename"), "Иванович");
        type(By.name("lastname"), "Иванов");
        type(By.name("nickname"), "Ванек");
        type(By.name("title"), "Заголовок");
        type(By.name("company"), "ООО Рога и копыта");
        type(By.name("address"), "г.Новосибирск ул.Кирова д.48");

        type(By.name("home"), "8 383 334 5555");
        type(By.name("mobile"), "8 913 728 7458");
        type(By.name("work"), "8 383 457 8564");
        type(By.name("fax"), "8 383 457 8565");

        type(By.name("email"), "ivanov.ii@rogaandkopit.su");
        type(By.name("email2"), "info@rogaandkopit.su");
        type(By.name("email3"), "zakaz@rogaandkopit.su");
    }
}
