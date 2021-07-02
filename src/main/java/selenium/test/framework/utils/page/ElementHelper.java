package selenium.test.framework.utils.page;

import org.openqa.selenium.WebElement;

public class ElementHelper {

    public static String getElementLogInfo(WebElement element) {
        String elementId= element.getAttribute("id");
        return "Element '" + element.getTagName() + "'" +
                (elementId != null && elementId.length() > 0 ? " with ID = '" + elementId + "'" : "");

    }
}
