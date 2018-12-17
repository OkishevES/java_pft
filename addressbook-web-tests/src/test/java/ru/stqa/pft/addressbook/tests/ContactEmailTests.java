package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ContactEmailTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
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
                            .withGroup("Group1"),
                    true);
        }
    }

    @Test
    public void testContactEmails() {
        ContactData contact = app.contact().all().iterator().next(); //contact is chosen by random method
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        MatcherAssert.assertThat(contact.getAllEmails(), CoreMatchers.equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).stream()
                .filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
    }
}
