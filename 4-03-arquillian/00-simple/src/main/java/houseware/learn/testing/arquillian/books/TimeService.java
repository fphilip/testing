package houseware.learn.testing.arquillian.books;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;

@Stateless
public class TimeService {
	@Inject
	private LocaleManager localeManager;

	public String getLocalizedTime(final Date date) {
		return localeManager.getSpecialDateFormat().format(date);
	}
}
