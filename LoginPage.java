package org.example;
import com.microsoft.playwright.Page;

public class LoginPage {
        private final Page page;

        public LoginPage(Page page) {
            this.page = page;
        }

        public void navigate() {
            page.navigate("https://the-internet.herokuapp.com/login");
        }

        public void login(String username, String password) {
            page.fill("#username", username);
            page.fill("#password", password);
            page.click("button[type='submit']");
        }

        public boolean isLoginSuccessful() {
            return page.locator(".flash.success").isVisible();
        }
    }
