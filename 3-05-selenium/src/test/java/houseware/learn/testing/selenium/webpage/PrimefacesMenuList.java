package houseware.learn.testing.selenium.webpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PrimefacesMenuList {
	@FindBy(how = How.ID, using = "SubMenu-Ajax")
	private WebElement searchResultWrapper;

	boolean containsSearchResult(final String term) {
		// for tutorial purpose only ;)
		return searchResultWrapper.getText().contains(term);
	}
}
