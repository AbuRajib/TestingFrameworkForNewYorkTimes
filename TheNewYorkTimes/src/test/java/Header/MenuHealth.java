package Header;
import BaseApi.Base;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by HP on 6/14/2015.
 */
public class MenuHealth extends Base {

    @Test
    public void menuHealth() throws InterruptedException {
        clickByXpath(".//*[@id='mini-navigation']/ul/li[13]/a");
        sleepFor(2);
        clickByXpath(".//*[@id='page']/div[3]/div[2]/div/ul/li[1]/a");
        sleepFor(1);

        List<String> list=getListOfTextByCss(".tabsContainer ul>li>a");
        displayText(list);
        for(int i=0;i<list.size();i++){
            clickByText(list.get(i));
        }
    }
}
