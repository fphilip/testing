package houseware.learn.testing.arquillian.books;

import javax.ejb.Stateless;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Stateless
public class LocaleManager {
	public DateFormat getSpecialDateFormat() {
		return new SimpleDateFormat("EEE, MMM d, yyyy");
	}
}
