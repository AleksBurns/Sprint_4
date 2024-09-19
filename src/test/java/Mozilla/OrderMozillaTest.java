package Mozilla;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.firefox.FirefoxDriver;
import scooter_POM.*;


import java.time.Duration;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderMozillaTest {
    private WebDriver driver;

    private final String nameField;
    private final String surnameField;
    private final String addressField;
    private final String stationName;
    private final String phoneField;
    private final String date;
    private final String rentPeriod;
    private final String colour;
    private final String comment;
    private final String button;

    public OrderMozillaTest(String button, String nameField, String surnameField, String addressField, String stationName, String phoneField, String date, String rentPeriod, String colour, String comment){
        this.nameField = nameField;
        this.surnameField = surnameField;
        this.addressField = addressField;
        this.stationName = stationName;
        this.phoneField = phoneField;
        this.date = date;
        this.rentPeriod = rentPeriod;
        this.colour = colour;
        this.comment = comment;
        this.button = button;

    }

    @Parameterized.Parameters
    public static Object[][] getOrderParam() {
        return new Object[][]{
                {"header", "Алекс", "Бёрнс", "Галактика Млечный путь", "Митино", "+71111111111", "10.11.2024", "двое суток", "Black", "Без комментариев..."},
                {"middle", "Василий", "Потерянный", "Где-то на нашей планете", "Речной вокзал", "+74815162342", "20.09.2024", "семеро суток", "Grey", "Хочется найтись"},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void orderTest(){
        driver.get(Values.URL);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickCookieButton();

        //Выбор кнопки для оформления заказа
        if(button.equals("header")){
            objMainPage.clickOrderButtonInHeader();
        } else if (button.equals("middle")) {
            objMainPage.clickMiddleOrderButton();
        }

        WhoIsTheScooterFor objWITSF = new WhoIsTheScooterFor(driver);
        objWITSF.setNameField(nameField);
        objWITSF.setSurnameField(surnameField);
        objWITSF.setAddressField(addressField);
        objWITSF.setSubwayField(stationName);
        objWITSF.setPhoneNumber(phoneField);
        objWITSF.clickNextButton();

        AboutRent objAR = new AboutRent(driver);
        objAR.setDate(date);
        objAR.setRentalPeriod(rentPeriod);
        objAR.setColour(colour);
        objAR.setComment(comment);
        objAR.clickOrderButton();

        DoneOrderWindow objDOW = new DoneOrderWindow(driver);
        objDOW.clickYesButton();
        assertTrue(objDOW.getOrderDoneText().contains(Values.EXPECTED_ORDER_DONE_TEXT));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}