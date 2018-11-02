package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void fillGroupForm() {
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
