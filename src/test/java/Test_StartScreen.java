import com.codeborne.selenide.SelenideElement;
import com.ice.screens.StartScreen;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


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
    @Order(2)
    /* Т.к. отсутствует зависимость между методами, то если разделять тестовую логику максимально атомарно,
     * при падении первого теста, последующие не будут скипнуты, а продолжат выполняться,
     * из за чего необходимо все шаги и тестовую логику определять в один тестовый метод. */
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
            x.should(be(visible)); /* как в selenide проверить, что элемент is hovered? */
            int index = list.indexOf(x);
            Assertions.assertEquals(toolset[index],x.getOwnText());
        });
    }

    @ParameterizedTest
    @Order(7)
    @ValueSource(strings = {"Product Specs","Hours","Holiday Hours","Expiry Calendar","Fees","Margins",
            "Subscriptions","System Alerts","ICE Education"})
    public void compareTextValue(String element) {
        startScreen.search.setValue(element);

    }

    @Test
    @Order(6)
    public void checkToolBarIsCollapsedAfterScroll(){
        startScreen.spacer.get(0).scrollTo();
        startScreen.toolset_label.get(0).should(be(disappear));
    }

    @Test
    @Order(8)
    public void checkContactsIsOpen(){
        startScreen.Contact.click();
    }
}