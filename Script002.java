package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Script002 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            Page page = browser.newPage();

            LoginPage loginPage = new LoginPage(page);
            loginPage.navigate();
            loginPage.login("tomsmith", "SuperSecretPassword!");

            System.out.println("Login successful: " + loginPage.isLoginSuccessful());

            browser.close();
        }
    }
}