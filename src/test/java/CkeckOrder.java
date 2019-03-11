import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class CkeckOrder extends PageObject{
    PageObject pageObject = new PageObject();

    @Test
    public void orderWithSelfDeliveryAndNonCashPayment(){
        open("https://shop.saint-gobain.ru");
        sleep(500);
        pageObject.selectTypeProduct();
        pageObject.selectProduct();
        pageObject.buyProduct();
        pageObject.fillingInfoAboutBuyer();
        pageObject.selectTypePay(PAY_BY_TRANSFER);
        pageObject.checkBuy();

    }
}
