package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContactsPage extends BasePage {

    @FindBy(id = "header-message")
    WebElement headerMessageAffix;

    @FindBy(id = "forename")
    WebElement fornameInput;

    @FindBy(id = "surname")
    WebElement surnameInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "telephone")
    WebElement telephoneInput;

    @FindBy(id = "message")
    WebElement messageTextarea;

    @FindBy(css = "form a.btn-primary")
    WebElement submitBtn;

    @FindBy(css = ".help-inline")
    List<WebElement> inlineErrors;

    @FindBy(css = "div[ui-if=contactValidSubmit] > div.alert-success")
    WebElement successMessageAlert;

    public ContactsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(headerMessageAffix));
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }

    public void setForename(String foreName) {
        fornameInput.sendKeys(foreName);
    }

    public void setSurname(String surname) {
        surnameInput.sendKeys(surname);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setTelephone(String telephone) {
        telephoneInput.sendKeys(telephone);
    }

    public void setMessage(String message) {
        messageTextarea.sendKeys(message);
    }

    public List<WebElement> getInlineErrors() {
        return inlineErrors;
    }

    public WebElement getValidSubmissionMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(successMessageAlert));
        return successMessageAlert;
    }

    public WebElement getHeaderMessage() {
        return headerMessageAffix;
    }
}
