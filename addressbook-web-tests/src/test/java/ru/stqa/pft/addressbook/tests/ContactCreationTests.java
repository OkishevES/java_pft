package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test (enabled = false)
    public void testContactCreation() throws Exception {
       app.goTo().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("Group","Иван", "Иванович", "Иванов", "Ванек", "Заголовок", "ООО Рога и копыта", "г.Новосибирск ул.Кирова д.48", "8 383 334 5555", "8 913 728 7458", "8 383 457 8564", "8 383 457 8565", "ivanov.ii@rogaandkopit.su", "info@rogaandkopit.su", "zakaz@rogaandkopit.su");
        app.getContactHelper().createContact(contact, true);
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);
    }
}
