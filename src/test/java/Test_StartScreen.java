import com.ice.screens.StartScreen;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/* https://selenide.org/javadoc/current/com/codeborne/selenide/Configuration.html */

public class Test_StartScreen extends Test_Base{

    public static final StartScreen startScreen = open("/", StartScreen.class);

    @Test
    public void checkAboutIsOpen(){
        startScreen.About.click();
        startScreen.Learn_more_about_ICE.shouldBe(visible);
    }

    @Test
    public void checkSolutionsIsOpen(){
        startScreen.Solutions.click();
        startScreen.Featured_Services.shouldBe(visible);
    }

    @Test
    public void checkResourcesIsOpen(){
        startScreen.Resources.click();
        startScreen.ICE_Product_Guide.shouldBe(visible);
    }

    @Test
    public void checkInsightsIsOpen(){
        startScreen.Insights.click();
        startScreen.Market_Pulse.shouldBe(visible);
    }

    @Test
    public void checkContactsIsOpen(){
        startScreen.Contact.click();
    }
}