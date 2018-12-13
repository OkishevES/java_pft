package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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





    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactModification(int i) {
        click(By.cssSelector("img[alt=\"Edit\"]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void returnToContactPage() {
        click(By.linkText("home"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void closeAlert() {
        wd.switchTo().alert().accept();
    }


    public void createContact(ContactData contactData, boolean creation) {
        initContactCreation();
        fillContactForm(contactData, creation);
        submitContactCreation();
    }


    public void fillContactForm(ContactData contactData, boolean creation) {
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

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public boolean isThereAContact() { return isElementPresent(By.name("selected[]")); }
    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements) {
            List<WebElement> columns = element.findElements(By.cssSelector("td"));
            String lastName = columns.get(1).getText();
            String firstName = columns.get(2).getText();
            String address = columns.get(3).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, null, firstName, null,  lastName, null, null, null,null,null, null, null, null, null, null, null);
            contacts.add(contact);
            System.out.println(firstName);
            System.out.println(lastName);
            System.out.println(address);
        }
        return contacts;
    }
}
