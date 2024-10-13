package scooter_POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class WhoIsTheScooterFor {
    private WebDriver driver;
    public WhoIsTheScooterFor(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор поля Имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Локатор поля Фамилия
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор поля Адрес
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор поля Станция метро
    private final By subwayField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Локатор названия станции метро из выпадающего списка
    private final String nameStateMetro = ".//button[@value='%s']";
    //Локатор поля Телефон
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор кнопки Далее
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public WhoIsTheScooterFor setNameField(String name){
        System.out.println("Заполнение поля Имя");
        driver.findElement(nameField).sendKeys(name);
        return this;
    }
    public WhoIsTheScooterFor setSurnameField(String surname){
        System.out.println("Заполнение поля Фамилия");
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }
    public WhoIsTheScooterFor setAddressField(String address){
        System.out.println("Заполнение поля Адрес");
        driver.findElement(addressField).sendKeys(address);
        return this;
    }
    public WhoIsTheScooterFor setSubwayField(String stationName) {
        System.out.println("Заполнение поля Станция метро");
        driver.findElement(subwayField).click();
        driver.findElement(By.xpath(".//div[text()='" + stationName + "']")).click();
        return this;
    }
    public WhoIsTheScooterFor setPhoneNumber(String phoneNumber) {
        System.out.println("Заполнение поля Телефон");
        driver.findElement(phoneField).sendKeys(phoneNumber);
        return this;
    }
    public void clickNextButton() {
        System.out.println("Клик по кнопке Далее");
        driver.findElement(nextButton).click();
    }
}
