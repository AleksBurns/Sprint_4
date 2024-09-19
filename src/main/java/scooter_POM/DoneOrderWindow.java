package scooter_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DoneOrderWindow {
    private WebDriver driver;
    public DoneOrderWindow(WebDriver driver){
        this.driver = driver;
    }
    //Локатор кнопки подтверждения заказа после заполнения формы
    private final By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    public void clickYesButton(){
        System.out.println("Клик по кнопке 'Да' для подтверждения заказа");
        driver.findElement(yesButton).click();
    }

    //Локатор надписи об успешном заказе после подтверждения
    private final By orderDoneText = By.xpath(".//div[text()='Заказ оформлен']");

    //Метод получения надписи об успешном заказе
    public String getOrderDoneText(){
        System.out.println("Проверка сообщения об успешном заказе");
        return driver.findElement(orderDoneText).getText();
    }
}
