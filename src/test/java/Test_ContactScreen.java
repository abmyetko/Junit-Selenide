import com.ice.screens.ContactScreen;
import com.ice.screens.StartScreen;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;


public class Test_ContactScreen extends Test_Base{

    public static final ContactScreen contactScreen = open("/", StartScreen.class).clickContact();

    @Test
    public void checkContactScreenIsOpen(){
        contactScreen.Personalized_Support.shouldBe(visible);
        contactScreen.Help_Desk_for_Trading_and_Clearing.scrollTo().hover();
    }

    @Test
    public void checkHelp_Desk_for_Trading_and_ClearingIsHovered(){
        contactScreen.Help_Desk_for_Trading_and_Clearing.scrollTo().hover();
    }
}