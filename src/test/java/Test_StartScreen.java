import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.ice.screens.StartScreen;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_StartScreen extends Test_Base{

    public static final StartScreen startScreen = open("/", StartScreen.class);

    @Test
    @Order(1)
    public void checkAboutIsOpen(){
        startScreen.About.click();
        startScreen.Learn_more_about_ICE.should(be(visible));
    }

    @Test
    @Order(2)//How can I make dependency between test methods? For example, the 1st test fails, the 2nd test(is it skipped or not)???
    public void checkSolutionsIsOpen(){
        startScreen.Solutions.click();
        startScreen.Featured_Services.should(be(visible));
    }

    @Test
    @Order(3)
    public void checkResourcesIsOpen(){
        startScreen.Resources.click();
        startScreen.ICE_Product_Guide.should(be(visible));
    }

    @Test
    @Order(4)
    public void checkInsightsIsOpen(){
        startScreen.Insights.click();
        startScreen.Market_Pulse.should(be(visible));
    }

    @Test
    @Order(5)
    public void checkNamesOfToolSetLabels(){
        String[] toolset = {"Product Specs","Hours","Holiday Hours","Expiry Calendar","Fees","Margins",
                "Subscriptions","System Alerts","ICE Education"};
        List<SelenideElement> list = startScreen.toolset_label;
        list.forEach(x -> {
            x.hover();
            x.should(be(visible));//How can I check is element hovered or not?
            int index = list.indexOf(x);
            assertEquals(toolset[index],x.getOwnText());
        });
    }

    @Test
    @Order(6)
    public void checkContactsIsOpen(){
        startScreen.Contact.click();
    }
}