package scooter_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private WebDriver driver;

    //Локатор кнопки принятия cookie
    private By cookieButton = By.xpath(".//*[@id='rcc-confirm-button']");

    ///Локатор блока "Вопросы о важном"
    private By questionsAboutImportant = By.className("Home_FourPart__1uthg");

    //Локаторы для панели с вопросами в разделе "Вопросы о важном"
    public static By question1 = By.id("accordion__heading-0");
    public static By question2 = By.id("accordion__heading-1");
    public static By question3 = By.id("accordion__heading-2");
    public static By question4 = By.id("accordion__heading-3");
    public static By question5 = By.id("accordion__heading-4");
    public static By question6 = By.id("accordion__heading-5");
    public static By question7 = By.id("accordion__heading-6");
    public static By question8 = By.id("accordion__heading-7");

    //Локаторы для панели с ответом в разделе "Вопросы о важном"
    public static By answer1 = By.id("accordion__panel-0");
    public static By answer2 = By.id("accordion__panel-1");
    public static By answer3 = By.id("accordion__panel-2");
    public static By answer4 = By.id("accordion__panel-3");
    public static By answer5 = By.id("accordion__panel-4");
    public static By answer6 = By.id("accordion__panel-5");
    public static By answer7 = By.id("accordion__panel-6");
    public static By answer8 = By.id("accordion__panel-7");

    //Локатор кнопки "Заказать" в заголовке страницы
    private By orderButtonInHeader = By.className("Button_Button__ra12g");
    //Локатор кнопки "Заказать" в середине страницы
    private By orderMiddleButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickCookieButton(){
        System.out.println("Клик по кнопке принятия cookie");
        if (driver.findElement(cookieButton).isDisplayed()) {
            driver.findElement(cookieButton).click();
        }
    }
    public void clickOrderButtonInHeader(){
        System.out.println("Клик по кнопке Заказать в заголовке страницы");
        driver.findElement(orderButtonInHeader).click();
    }
    public void clickMiddleOrderButton(){
        System.out.println("Клик по кнопке Заказать в середине страницы");
        driver.findElement(orderMiddleButton).click();
    }
    public void scrollToQuestions(){
        System.out.println("Скролл страницы до блока \"Вопросы о важном\"");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsAboutImportant));
    }
    //Клик по кнопке с вопросом
    public void clickButtonWithQuestion(By questionsPanel){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(questionsPanel)).click();
    }
    //Ожидание появления ответа
    public void waitToShowAnswer(By accordionPanel) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(accordionPanel).getText() != null && !driver.findElement(accordionPanel).getText().isEmpty()));
    }
}