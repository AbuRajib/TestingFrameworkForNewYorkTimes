package Header;

import BaseApi.Base;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by HP on 6/13/2015.
 */
public class MenuWorld  extends Base{

    @Test

    public void menuWorld() throws InterruptedException {
        clickByXpath(".//*[@id='mini-navigation']/ul/li[3]/a");
        sleepFor(2);

        List<String> element=getListOfTextByCss("#navWorld ul>li>a");
        displayText(element);
        for(int i=0;i<element.size();i++){
            clickByText(element.get(i));
        }
    }
}
