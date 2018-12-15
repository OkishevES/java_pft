package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                            .withFirstName("Ivanov1")
                            .withLastName("Ivan")
                            .withMiddleName("Ivanovich1")
                            .withNickName("VANYA")
                            .withTitle("TestVanya1")
                            .withCompany("Testiroff")
                            .withAddress("Novocibirsk1")
                            .withHomePhone  ("+7(383)545543")
                            .withMobilePhone("+7(913)545544")
                            .withWorkPhone  ("+7(913)545545")
                            .withEmail("ivanov@gmail.com")
                            .withGroup("Group1"),
                    true);
        }
    }

    @Test
    public void testContactDeletion() throws Exception {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().сount(), equalTo(before.size()- 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deletedContact)));
    }

}
