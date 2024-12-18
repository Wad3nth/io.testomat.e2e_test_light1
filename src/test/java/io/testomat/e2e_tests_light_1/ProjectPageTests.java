package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests {

    String baseUrl = "https://app.testomat.io/users/sign_in";


    @Test
    public void firstTest() {
        open(baseUrl);

        LoginUser();

        SearchProject();

        SelectProject();

        WaitForProjectPageIsLoaded();

    }

    private static void WaitForProjectPageIsLoaded() {
        $("h2").shouldHave(Condition.text("Manufacture light"));
    }

    private static void SelectProject() {
        $(byText("Manufacture light")).click();
        sleep(10000);
    }

    private static void SearchProject() {
        $("#search").setValue("Manufacture light");
    }

    private static void LoginUser() {
        $("#content-desktop #user_email").setValue("skeletosik2456@gmail.com");
        $("#content-desktop #user_password").setValue("Testomatio_123!");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        Selenide.$(".common-flash-success").shouldBe(Condition.visible);
    }


}


