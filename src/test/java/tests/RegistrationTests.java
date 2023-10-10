package tests;

import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest{
    
    @Test
    public void positiveRegistration() {
        String email = randomUtils.generateEmail(7);

        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("123456Aa$")
                .lastName("abdfg")
                .name("test")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterRegistration());
    }
}
