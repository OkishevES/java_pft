package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
    @Test
    public void testContactModification(){
        app.getNavigationHepler().gotoContactPage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData(
                null,
                "test1",
                "test2",
                "test3",
                "test4",
                "test5",
                "test6",
                "test17",
                "test8",
                "test9",
                "test9",
                "test10",
                "test11",
                "test12",
                "test13"
        ),false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
    }
}
