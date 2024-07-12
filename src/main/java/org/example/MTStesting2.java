package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.example.MTStest2.driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MTStesting2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.mts.by/");
        WebElement buttonCook = driver.findElement(By.xpath("//div[@class='cookie__buttons']/button[@id='cookie-agree']"));
        buttonCook.click();
    }

        @Test
        public void communicationServices() {

            WebElement element = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Услуги связи')]"));
            element.click();
            LinkedList<String> expectedText = new LinkedList<>();
            expectedText.add(0, "Номер телефона");
            expectedText.add(1, "Сумма");
            expectedText.add(2, "E-mail для отправки чека");
            LinkedList<String> actualText = new LinkedList<>();
            Assertions.assertEquals(expectedText, actualText);
        }

        @Test
        public void homeInternet() {
            WebElement element = driver.findElement(By.xpath("//select[@id='pay']"));
            WebElement element2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Домашний интернет')]"));

            Actions action = new Actions(driver);
            action.click(element);
            action.click(element2);
            LinkedList<String> expectedText = new LinkedList<>();
            expectedText.add(0, "Номер абонента");
            expectedText.add(1, "Сумма");
            expectedText.add(2, "E-mail для отправки чека");
            LinkedList<String> actualText = new LinkedList<>();
            Assertions.assertEquals(expectedText, actualText);
        }

        @Test
        public void installmentPlan() {
            WebElement element = driver.findElement(By.xpath("//select[@id='pay']"));
            WebElement element2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Рассрочка')]"));

            Actions action = new Actions(driver);
            action.click(element);
            action.click(element2);
            LinkedList<String> expectedText = new LinkedList<>();
            expectedText.add(0, "Номер счета на 44");
            expectedText.add(1, "Сумма");
            expectedText.add(2, "E-mail для отправки чека");
            LinkedList<String> actualText = new LinkedList<>();
            Assertions.assertEquals(expectedText, actualText);
        }

        @Test
    public void debt() {
            WebElement element = driver.findElement(By.xpath("//select[@id='pay']"));
            WebElement element2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Задолженность')]"));

            Actions action = new Actions(driver);
            action.click(element);
            action.click(element2);
            LinkedList<String> expectedText = new LinkedList<>();
            expectedText.add(0, "Номер счета на 2073");
            expectedText.add(1, "Сумма");
            expectedText.add(2, "E-mail для отправки чека");
            LinkedList<String> actualText = new LinkedList<>();
            Assertions.assertEquals(expectedText, actualText);
        }

        @Test
    public void checkCommunicationServices() {
        String phone = "297777777";
        String summ = "100";

            WebElement element = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Услуги связи')]"));
            element.click();
            WebElement putPhone = driver.findElement(By.xpath("//input[@id='connection-phone']"));
            putPhone.sendKeys(phone);
            WebElement putSumm = driver.findElement(By.xpath("//input[@id='connection-sum']"));
            putSumm.sendKeys(summ);
            WebElement button = driver.findElement(By.xpath("//form[@id='pay-connection']/button"));
            button.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            driver.findElements(By.linkText(summ));

            List<WebElement> cards = driver.findElements(By.xpath("//app-payment-container/descendant::input[@id='cc-number']/parent::*/following::img"));
            int cardsNum = 4;
            Assertions.assertEquals(cards, cardsNum);

            WebElement elementPhone = driver.findElement(By.xpath("//app-payment-container/descendant::*[contains(text(),'" + phone + "')]"));
            String phoneText = elementPhone.getAttribute("innerHTML").replaceAll("[^.\\d]", "");
            Assertions.assertTrue(phoneText.equals("375" + phone));

            List<WebElement> elementsInput = driver.findElements(By.xpath("//app-payment-container/descendant::input/following-sibling::label"));
            LinkedList<String> expectedText = new LinkedList<>();
            expectedText.add(0, "Номер карты");
            expectedText.add(1, "Срок действия");
            expectedText.add(2, "CVC");
            expectedText.add(3, "Имя держателя (как на карте)");
            LinkedList<String> actualText = new LinkedList<>();
            Assertions.assertTrue(actualText.equals(expectedText));
        }
}

