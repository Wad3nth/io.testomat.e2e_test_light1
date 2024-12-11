package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests {

    @Test
    public void firstTest() {
        open("https://app.testomat.io/users/sign_in");

        //login user
        $("#content-desktop #user_email").setValue("skeletosik2456@gmail.com");
        $("#content-desktop #user_password").setValue("Testomatio_123!");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        Selenide.$(".common-flash-success").shouldBe(Condition.visible);

        //search project
        $("#search").setValue("Manufacture light");

        //select project
        $(byText("Manufacture light")).click();
        sleep(10000);

        //wait for project is loaded
        $("h2").shouldHave(Condition.text("Manufacture light"));


    }
}
