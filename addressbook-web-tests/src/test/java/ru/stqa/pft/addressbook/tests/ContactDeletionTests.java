package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests  extends TestBase{
    @Test
    public void testContactModification(){
        app.getNavigationHepler().gotoContactPage();
        if(! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("test1", "test2", "test3", "test4", "test5", "test6", "test17", "test8", "test9", "test9", "test10", "test11", "test12", "test13", "test14"),true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().closeAlert();
        app.getContactHelper().returnToContactPage();


    }
}
