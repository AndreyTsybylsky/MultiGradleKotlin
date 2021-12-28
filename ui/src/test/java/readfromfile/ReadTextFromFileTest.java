package readfromfile;


import core.driver.WebElementActions;
import core.excptions.NoPropertiesException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobject.LoginPage;
import utils.LoginPageHelperUi;
import utils.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadTextFromFileTest extends BaseTest {

    @BeforeEach
    void beforeEach() {

    }

    @AfterEach
    void afterEach() {
    }

    @Test
    void readingTextFromFile() throws IOException {

        String fileName = "C:\\Users\\MultiGradleKotlin\\ui\\src\\test\\resources\\notes3.txt";

        String contents = readUsingScanner(fileName);

        String example = "hello world";
        Assertions.assertEquals(example, contents, "we have correct text line");
    }

    @Test
    void login() throws NoPropertiesException {
        loginPageHelperUi.openLoginPage();
        User user = User.builder()
                .name("tomsmith")
                .pass("SuperSecretPassword!")
                .build();
         loginPageHelperUi.login(user);

        Assertions.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure","" );


    }

    @Test
    void loginViaIncorrectData() throws NoPropertiesException {
        loginPageHelperUi.openLoginPage();
        User user = User.builder()
                .name("tomsmith!")
                .pass("SuperSecretPassword!!")
                .build();
         loginPageHelperUi.login(user);

        Assertions.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login","" );


    }

    private static String readUsingScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        String data = scanner.useDelimiter("\\A").next();
        scanner.close();
        return data;
    }


}

