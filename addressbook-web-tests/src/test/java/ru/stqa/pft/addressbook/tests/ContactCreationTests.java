package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.initContactCreation();
        app.getGroupHelper().fillGroupForm();
        app.submitContactCreation();

    }
}
