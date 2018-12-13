package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactDeletionTests  extends TestBase{

    @Test(enabled = false)
    public void testContactDeletion() throws Exception {
        app.getNavigationHepler().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test1", "test2", "test3", "test4", "test5", "test6", "test17", "test8", "test9", "test9", "test10", "test11", "test12", "test13", "test14"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHepler().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().closeAlert();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Comparator<? super ContactData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);
    }
}
