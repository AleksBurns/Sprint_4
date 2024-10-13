package Mozilla;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import scooter_POM.MainPage;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static scooter_POM.MainPage.*;
import static scooter_POM.Values.*;

@RunWith(Parameterized.class)
public class QAMozillaTest {
    private WebDriver driver;

    private final By questions;
    private final By answers;
    private final By result;
    private final String expected;

    public QAMozillaTest(By questions, By answers, By result, String expected) {
        this.questions = questions;
        this.answers = answers;
        this.result = result;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getParam() {
        return new Object[][]{
                {question1, answer1, FTEXT1, WTEXT1},
                {question2, answer2, FTEXT2, WTEXT2},
                {question3, answer3, FTEXT3, WTEXT3},
                {question4, answer4, FTEXT4, WTEXT4},
                {question5, answer5, FTEXT5, WTEXT5},
                {question6, answer6, FTEXT6, WTEXT6},
                {question7, answer7, FTEXT7, WTEXT7},
                {question8, answer8, FTEXT8, WTEXT8},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(URL);
    }

    @Test
    public void testQuestionsAboutImportant() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.scrollToQuestions();
        mainPage.clickButtonWithQuestion(questions);
        mainPage.waitToShowAnswer(result);
        String actual = driver.findElement(answers).getText();

        assertEquals(expected, actual);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}