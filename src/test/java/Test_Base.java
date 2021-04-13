import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import static com.codeborne.selenide.Selenide.closeWebDriver;

/* https://selenide.org/javadoc/current/com/codeborne/selenide/Configuration.html */

@ExtendWith({ScreenShooterExtension.class})
public class Test_Base {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("target/screenshots");

    @BeforeAll
    static void setUp(){
        closeWebDriver();
        Configuration.baseUrl = "https://www.theice.com";
        Configuration.startMaximized = true;
    }
}