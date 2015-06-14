package Header;
import BaseApi.Base;
import org.testng.annotations.Test;

/**
 * Created by HP on 6/14/2015.
 */
public class MenuArts extends Base {

    @Test
    public void arts() throws InterruptedException {
        clickByXpath(".//*[@id='mini-navigation']/ul/li[16]/a");

        clickByXpath(".//*[@id='subNav_television']/a");
        sleepFor(2);

        String storyHeader=getTextByXpath(".//*[@id='main']/div/div/div[1]/div[1]/div[1]/div[1]/div[1]/h2/a");
        System.out.println(storyHeader);
    }
}
