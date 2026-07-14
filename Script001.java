package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Script001 {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            Page page = browser.newPage();

            page.navigate("https://the-internet.herokuapp.com/");
            page.click("text=Form Authentication");
            page.fill("#username", "tomsmith");
            page.fill("#password", "SuperSecretPassword!");
            page.click("button[type='submit']");

            PlaywrightAssertions.assertThat(page.locator(".flash.success")).isVisible();

            System.out.println("Login test passed!");
        }
    }
}