import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageObject {
    SelenideElement LIST_TYPE_PRODUCT = $(byXpath("//li[@class='item menu-2']/a")); // пункт меню
    SelenideElement PRODUCT_BTN = $(byXpath("//div[1][@class='b-product']//div[@class='btn']")); // кнопка добавляет товар в корзину
    SelenideElement COUNT =$(byXpath("//*[@id='spinner']"));
    SelenideElement ORDER_BNT =$(byXpath("//span[text()='в корзину']"));
    SelenideElement PICKUP = $(byXpath("//*[@id='edit-delivery-type-1']/../div"));
    SelenideElement CALCULATOR_SHIPPING = $(byXpath("//*[@id='edit-checkout']"));
    SelenideElement EDIT_CONTINUE_BTN = $(byXpath("//*[@id='edit-continue']"));// кнопка "Продолжить"

    SelenideElement E_MAIL = $(byXpath("//*[@id='edit-customer-profile-billing-field-customer-recepient-email-und-0-value']"));
    SelenideElement NAME = $(byXpath("//*[@id='edit-customer-profile-billing-field-user-first-name-und-0-value']"));
    SelenideElement LAST_NAME = $(byXpath("//*[@id='edit-customer-profile-billing-field-user-last-name-und-0-value']"));
    SelenideElement PHONE = $(byXpath("//*[@id='edit-customer-profile-billing-field-user-phone-und-0-value']"));
    SelenideElement I_AGREE = $(byXpath("//*[@id='uniform-edit-customer-profile-billing-agreement']"));

    SelenideElement PAY_BY_TRANSFER = $(byXpath("//*[@id='edit-commerce-payment-payment-method']/div[4]/div")); // тип платежа "Безналичный расчет"

    SelenideElement RESULT = $(byXpath("//div[@class='order-complete']")); // Номер заказа


    public void scrollToElementViaJS(SelenideElement element) {
        executeJavaScript("arguments[0].scrollIntoView();", element);
    }

    public void selectTypeProduct(){
        $(byXpath("/html/body/header/div[1]/div/div/div[1]/div/div/div[2]/div[2]/span[1]")).click();
        LIST_TYPE_PRODUCT.click();
    }

    public void selectProduct(){
        PRODUCT_BTN.click();
    }

    public void clickContinue(){
        EDIT_CONTINUE_BTN.click();
    }

    public void buyProduct(){
        COUNT.clear();
        COUNT.sendKeys("1");
        ORDER_BNT.click();
        scrollToElementViaJS(PICKUP);
        PICKUP.click();
        CALCULATOR_SHIPPING.click();
    }

    public void fillingInfoAboutBuyer(){
        E_MAIL.setValue("test@mail.ru");
        NAME.setValue("Тест");
        LAST_NAME.setValue("Тест");
        PHONE.setValue("1234567812");
        scrollToElementViaJS(PHONE);
        I_AGREE.click();
        clickContinue();
    }

    public void selectTypePay(SelenideElement type){
        type.click();
        clickContinue();
    }

    public void checkBuy(){
        RESULT.shouldBe(visible);
    }
}
