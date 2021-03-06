package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager app) {
        super(app);
    }

    public void submitGroupCreation() {
        click(By.xpath("//input[@value='Enter information']"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupname());
        type(By.name("group_header"), groupData.getGroupheader());
        type(By.name("group_footer"), groupData.getGroupfooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    private void selectGroupById(int grid) {
        driver.findElement(By.cssSelector("input[value='" + grid + "']")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    //Создание
    public void create(GroupData groupData) {
        initGroupCreation();
        fillGroupForm(groupData);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }
    //Изменение
    public void modify(GroupData group) {
        selectGroupById(group.getGrid());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }
    //Удаление
    public void delete(GroupData group) {
        selectGroupById(group.getGrid());
        deleteSelectedGroups();
        groupCache = null;
        returnToGroupPage();
    }
    //количество элементов коллекции
    public int сount() {
        return driver.findElements(By.name("selected[]")).size(); }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }

    //создаем кэш
    private Groups groupCache = null;

    public Groups all(){
        if (groupCache != null) {
            return new Groups(groupCache);
        }

        groupCache = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int grid = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(grid).withName(name));
        }
        return new Groups(groupCache);
    }
}
