import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.closeWebDriver;


public class Test_Base {

    @BeforeAll
    static void setUp(){
        closeWebDriver();
        Configuration.baseUrl = "https://www.theice.com";
    }
}