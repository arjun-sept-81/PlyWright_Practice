package org.example;

import static org.testng.AssertJUnit.assertTrue;              // ← assertTrue from TestNG
import com.microsoft.playwright.*;
import org.junit.Test;

public class Script003 {

    @Test
    public void testValidLogin() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();

            LoginPage loginPage = new LoginPage(page);
            loginPage.navigate();
            loginPage.login("tomsmith", "SuperSecretPassword!");

            assertTrue(loginPage.isLoginSuccessful());
            browser.close();
        }
    }
}