package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests  extends TestBase{
    @Test
    public void testContactModification(){
        app.getNavigationHepler().gotoContactPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().closeAlert();
        app.getContactHelper().returnToContactPage();


    }
}
