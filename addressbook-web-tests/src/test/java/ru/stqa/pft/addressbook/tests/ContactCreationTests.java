package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("Ivanov")
                .withLastName("Ivan")
                .withMiddleName("Ivanovich")
                .withNickName("VANYA")
                .withTitle("TestVanya1")
                .withCompany("Testiroff")
                .withAddress("Novocibirsk")
                .withHomePhone  ("+7(383)545543")
                .withMobilePhone("+7(913)545544")
                .withWorkPhone  ("+7(913)545545")
                .withEmail("ivan1@gmail.com")
                .withEmail2("ivan2@gmail.com")
                .withEmail3("ivan3@gmail.com")
                .withGroup("Group1");
        app.contact().create(contact, true);
        assertThat(app.contact().сount(), equalTo(before.size()+ 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
