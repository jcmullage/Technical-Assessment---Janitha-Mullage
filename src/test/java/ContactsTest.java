import domain.Contacts;
import domain.Home;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactsTest extends BaseTest {

    @Test
    public void testSubmitEmptyForm() {
        Home home = new Home(driver);
        Contacts contacts = home.navigateToContacts();
        List<String> errors = contacts.submitWithInvalidData(null, null, null, null, null);
        List<String> expectedErrors = Arrays.asList("Forename is required",
                "Email is required",
                "Message is required",
                "We welcome your feedback - but we won't get it unless you complete the form correctly.");
        assertThat(errors).containsExactlyInAnyOrderElementsOf(expectedErrors);
    }

    @Test
    public void testSubmitFormWithMandatoryFields() {
        Home home = new Home(driver);
        Contacts contacts = home.navigateToContacts();
        String successMessage = contacts.submitWithValidData("John", null, "john@example.com",
                null, "This is a test message");
        assertThat(successMessage).contains("Thanks John, we appreciate your feedback.");

    }

    @Test
    public void testSubmitInvalidMandatoryData() {
        Home home = new Home(driver);
        Contacts contacts = home.navigateToContacts();
        String invalidForename = "999";
        String invalidEmail = "invalid mail";
        String invalidMessage = "z";
        List<String> errors = contacts.submitWithInvalidData(invalidForename, null, invalidEmail, null, invalidMessage);
        List<String> expectedErrors = Arrays.asList("Please enter a valid email",
                "We welcome your feedback - but we won't get it unless you complete the form correctly.");
        assertThat(errors).containsAnyElementsOf(expectedErrors);

        /*This test is designed to fail as I think this is a defect identified by this test
        1. Name should be validated for characters
        2. Message should have a reasonable min length */

        assertThat(errors.size()).isEqualTo(4); //Alert message and three inline errors expected
    }

}
