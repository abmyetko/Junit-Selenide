import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AusAnalyzerDemoTest {

    public By itemToBeHovered = By.cssSelector("div#u11571.ax_default");
    public By el2 = By.cssSelector("div#u11571_state1.panel_state");
    public By dot = By.cssSelector("div#u11583_state0.panel_state");

    //<div id="u11405" class="ax_default" data-label="DU4">
    public By itemToBeHovered2 = By.cssSelector("div[id*='u114'][data-label*='DU'][class='ax_default']");

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://gwh5t1.axshare.com/#id=rguhtg&p=aus_demo_2020_jan_18&c=1";
        Configuration.startMaximized = true;
        open("/");
    }

    @Test
    public void makeItemsHovered(){
        switchTo().innerFrame("mainFrame");
        $$(itemToBeHovered2).forEach(SelenideElement::hover);
    }

    @Test
    public void checkItemHasReadStatus(){
        switchTo().innerFrame("mainFrame");
        $(itemToBeHovered).hover();
        Assertions.assertEquals("Read",$(dot).getAttribute("data-label"));
        Assertions.assertEquals("visibility: inherit;",$(el2).getAttribute("style"));
    }

}