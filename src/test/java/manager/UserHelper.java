package manager;

import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class UserHelper extends BaseHelper{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnLoginNavigatorMenu = By.xpath("//a[contains(@href, '/login')]");
    By inputEmailLoginForm = By.xpath("//input[@id='email']");
    By inputPasswordLoginForm = By.xpath("//input[@id='password']");
    By btnYallaLoginForm = By.xpath("//button[@type='submit']");
    By textSuccessLoginPopUp = By.xpath("//h2[@class='message']");
    By btnOpenRegForm = By.xpath("//a[contains(@href, '/registration')]");
    By inputNameReg = By.xpath("//input[@id='name']");
    By inputLastNameReg = By.xpath("//input[@id='lastName']");
    By inputEmailReg = By.xpath("//input[@id='email']");
    By inputPasswordReg = By.xpath("//input[@id='password']");
    String btnRegNewUser = "document.querySelector('#terms-of-use').click();";
    String btnOkPopUpStr = "document.querySelector(`[type='button']`).click();";
    By checkBoxReg = By.xpath("//label[@for='terms-of-use']");
    By btnUallaReg = By.xpath("//button[@type='submit']");
    By textPopUpSuccessRegH1 = By.xpath("//div[@class='dialog-container']//h1[@class='title']");
    By btnLogout = By.xpath("//a[contains(@href, 'logout')]");
    By btnOkPopUp = By.xpath("//button[@type='button']");

    public void login(UserDTO userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnYallaLoginForm);
    }

    public void login(UserDTOWith userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnYallaLoginForm);
    }

    public void loginUserDtoLombok(UserDtoLombok user) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        clickBase(btnYallaLoginForm);
    }

    public boolean validatePopUpMessageSuccessAfterLogin() {
        return isTextEqual(textSuccessLoginPopUp, "Logged in success");
    }

    public boolean validatePopUpMessageLoginIncorrect() {
        return isTextEqual(textSuccessLoginPopUp, "\"Login or Password incorrect\"");
    }

    public void fillRegistrationForm(UserDtoLombok user) {
        clickBase(btnOpenRegForm);
        typeTextBase(inputNameReg, user.getName());
        typeTextBase(inputLastNameReg, user.getLastName());
        typeTextBase(inputEmailReg, user.getEmail());
        typeTextBase(inputPasswordReg, user.getPassword());
        //clickBase(checkBoxReg);
        clickByXY(checkBoxReg, 5,15);
        //jsClickBase(btnRegNewUser);
        clickBase(btnUallaReg);
    }

    public boolean validatePopUpMessageSuccessAfterRegistration() {
        String expectedResult = "Registered".toUpperCase();
        return isTextEqual(textPopUpSuccessRegH1, expectedResult);
    }

    public boolean btnLogoutExist() {
        return isElementExist(btnLogout);
    }

    public void logout() {
        clickBase(btnLogout);
    }

    public void clickOkPopUpSuccessLogin() {
       // jsClickBase(btnOkPopUpStr);
       // clickByXY(btnOkPopUp, 0.5, 2);

//        Actions actions = new Actions(driver);
//        // Use the sendKeys method to simulate pressing the "Enter" key on the active element
//        actions.sendKeys(Keys.ENTER).perform();
    }
}
