package Header;
import BaseApi.Base;
import org.testng.annotations.Test;

/**
 * Created by HP on 6/14/2015.
 */
public class MenuFood extends Base {

    @Test
    public void food() throws InterruptedException {
        clickByXpath(".//*[@id='mini-navigation']/ul/li[20]/a");
        sleepFor(2);

        clickByXpath(".//*[@id='page']/div[3]/div[2]/div/ul/li[1]/a");
        sleepFor(2);

        clickByXpath(".//*[@id='site-links-rb']/span");
        sleepFor(1);

        clickByXpath(".//*[@id='simmer']/div/div/button[1]");
        sleepFor(1);

        clickByXpath(".//*[@id='simmer']/div/div/button[2]");
        sleepFor(2);

        clickByXpath(".//*[@id='simmer']/div/div/button[2]");
        sleepFor(2);

        clickByXpath(".//*[@id='simmer']/div/div/button[2]");
        sleepFor(2);

        clickByXpath(".//*[@id='simmer']/div/div/button[2]");
        sleepFor(2);

        clickByXpath(".//*[@id='simmer']/div/div/button[1]");
        sleepFor(2);

        clickByXpath(".//*[@id='simmer']/div/div/button[1]");
        sleepFor(2);

        clickByXpath(".//*[@id='simmer']/div/div/button[2]");
        sleepFor(2);

        clickByXpath(".//*[@id='simmer']/div/div/button[2]");
        sleepFor(2);

        clickByXpath(".//*[@id='simmer']/div/div/button[1]");
        sleepFor(2);

        clickByXpath(".//*[@id='simmer']/div/div/button[2]");
        sleepFor(2);

        clickByXpath(".//*[@id='simmer']/div/div/button[2]");
        sleepFor(2);

        clickByXpath(".//*[@id='simmer']/div/div/button[2]");
        sleepFor(2);

        clickByXpath(".//*[@id='simmer']/div/div/button[2]");
        sleepFor(2);

        clickByXpath(".//*[@id='simmer']/div/header/button");
        sleepFor(2);


    }
}
