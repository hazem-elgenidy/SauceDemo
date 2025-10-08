package routeassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class javalocators {

    public static void main(String[] args) {
        // Set up WebDriver (make sure chromedriver is in your PATH)
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the website
            driver.get("https://www.saucedemo.com");
            driver.manage().window().maximize();

            //  LOGIN PAGE ELEMENTS

            // 1. Username input field - By ID
            WebElement usernameField = driver.findElement(By.id("user-name"));
            System.out.println("Username field found using ID: " + usernameField.getAttribute("placeholder"));

            // 2. Password input field - By Name
            WebElement passwordField = driver.findElement(By.name("password"));
            System.out.println("Password field found using Name: " + passwordField.getAttribute("placeholder"));

            // 3. Login button - By ID
            WebElement loginButton = driver.findElement(By.id("login-button"));
            System.out.println("Login button found using ID: " + loginButton.getAttribute("value"));

            // 4. App logo - By Class Name
            WebElement appLogo = driver.findElement(By.className("login_logo"));
            System.out.println("App logo found using Class Name: " + appLogo.getText());

            // Perform login
            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");
            loginButton.click();

            // Wait for page to load
            Thread.sleep(2000);

            // INVENTORY PAGE ELEMENTS

            // 5. Cart icon - By Class Name
            WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
            System.out.println("Cart icon found using Class Name");

            // 6. Product name (Sauce Labs Backpack) - By XPath
            WebElement productName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
            System.out.println("Product name found using XPath: " + productName.getText());

            // 7. Add to Cart button - By CSS Selector
            WebElement addToCartButton = driver.findElement(By.cssSelector("button[id='add-to-cart-sauce-labs-backpack']"));
            System.out.println("Add to Cart button found using CSS Selector: " + addToCartButton.getText());

            // 8. Sort dropdown - By Class Name
            WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
            Select select = new Select(sortDropdown);
            System.out.println("Sort dropdown found using Class Name. Default option: " +
                    select.getFirstSelectedOption().getText());

            // 9. LinkedIn link - By Link Text
            WebElement linkedInLink = driver.findElement(By.linkText("LinkedIn"));
            System.out.println("LinkedIn link found using Link Text: " + linkedInLink.getAttribute("href"));

            // 10. Twitter link - By Partial Link Text
            WebElement twitterLink = driver.findElement(By.partialLinkText("Twitter"));
            System.out.println("Twitter link found using Partial Link Text: " + twitterLink.getAttribute("href"));

            // Demonstrate interactions
            System.out.println("\n===== Demonstrating Element Interactions =====");
            addToCartButton.click();
            System.out.println("✓ Added backpack to cart");

            select.selectByVisibleText("Price (low to high)");
            System.out.println("✓ Changed sort order");

            cartIcon.click();
            Thread.sleep(2000);
            System.out.println("✓ Navigated to cart");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
