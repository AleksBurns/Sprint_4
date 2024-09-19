package scooter_POM;

import org.openqa.selenium.By;

public interface Values {
    //URL сайта для тестирования
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    //ОР текста сообщения об успешном заказе
    public static final String EXPECTED_ORDER_DONE_TEXT = "Заказ оформлен";

    //ОР в тексте ответа
    public static final String WTEXT1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String WTEXT2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String WTEXT3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String WTEXT4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String WTEXT5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String WTEXT6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String WTEXT7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String WTEXT8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    //ФР
    public static final By FTEXT1 = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-0']");
    public static final By FTEXT2 = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-1']");
    public static final By FTEXT3 = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-2']");
    public static final By FTEXT4 = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-3']");
    public static final By FTEXT5 = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-4']");
    public static final By FTEXT6 = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-5']");
    public static final By FTEXT7 = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-6']");
    public static final By FTEXT8 = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-7']");

    //public static final String ONE =

}
