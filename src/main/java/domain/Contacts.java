package domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.ContactsPage;

import java.util.ArrayList;
import java.util.List;

public class Contacts extends JupiterBase {

    ContactsPage contactsPage;

    public Contacts(WebDriver driver) {
        contactsPage = new ContactsPage(driver);
    }

    public void submitForm(String forename, String surname,
                           String email, String telephone, String message) {
        if (forename != null && !forename.isEmpty()) {
            contactsPage.setForename(forename);
        }
        if (surname != null && !surname.isEmpty()) {
            contactsPage.setSurname(forename);
        }
        if (email != null && !email.isEmpty()) {
            contactsPage.setEmail(email);
        }
        if (telephone != null && !telephone.isEmpty()) {
            contactsPage.setTelephone(telephone);
        }
        if (message != null && !message.isEmpty()) {
            contactsPage.setMessage(message);
        }
        contactsPage.clickSubmitBtn();
    }

    public List<String> getErrorMessages() {
        List<String> errors = new ArrayList<>();
        List<WebElement> inlineErrors = contactsPage.getInlineErrors();
        for (WebElement inlineError : inlineErrors) {
            errors.add(inlineError.getText());
        }
        errors.add(contactsPage.getHeaderMessage().getText());
        return errors;
    }

    public String getSuccessMessage() {
        return contactsPage.getValidSubmissionMessage().getText();
    }

    public String submitWithValidData(String forename, String surname,
                                      String email, String telephone, String message) {
        submitForm(forename, surname, email, telephone, message);
        return getSuccessMessage();

    }

    public List<String> submitWithInvalidData(String forename, String surname,
                                              String email, String telephone, String message) {
        submitForm(forename, surname, email, telephone, message);
        return getErrorMessages();
    }

    @Override
    BasePage getCurrentPage() {
        return contactsPage;
    }
}
