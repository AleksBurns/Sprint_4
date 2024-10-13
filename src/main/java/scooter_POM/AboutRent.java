package scooter_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AboutRent {
    private WebDriver driver;
    public AboutRent(WebDriver driver){
        this.driver = driver;
    }

    //Локатор поля Дата
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Локатор выпадающего списка с выбором срока аренды
    private final By rentalPeriodField = By.xpath(".//span[@class='Dropdown-arrow']");
    //Локатор для чекбокса цвета чёрный жемчуг
    private final By colourBlack = By.id("black");
    //Локатор для чекбокса цвета серая безысходность
    private final By colourGrey = By.id("grey");
    //Локатор поля Комментарий
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Локатор кнопки Заказать
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public AboutRent setDate(String date) {
        System.out.println("Заполнение поля Дата");
        driver.findElement(dateField).sendKeys(date);
        return this;
    }
    public AboutRent setRentalPeriod(String rentPeriod){
        System.out.println("Выбор Срока аренды");
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(".//div[text()='"+rentPeriod+"']")).click();
        return this;
    }
    public AboutRent setColour(String colour){
        System.out.println("Выбор цвета самоката");
        if(colour.equals("Black")){
            driver.findElement(colourBlack).click();
        } else if (colour.equals("Grey")) {
            driver.findElement(colourGrey).click();
        }
        return this;
    }
    public AboutRent setComment(String comment){
        System.out.println("Добавление комментария к заказу");
        driver.findElement(commentField).sendKeys(comment);
        return this;
    }
    public void clickOrderButton(){
        System.out.println("Клик по кнопке Заказать");
        driver.findElement(orderButton).click();
    }
}