package houseware.learn.testing.arquillian.books;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "bookControllerBean")
@RequestScoped
public class BookControllerBean {
	@Inject
	private BookEJB bookEJB;

	private Book book = new Book();

	public String save() {
		bookEJB.saveBook(book);
		return "/books.xhtml";
	}

	public List<Book> getBooks() {
		return bookEJB.findAllBooks(); // we're lazy here ;)
	}

	public Book getBook() {
		return book;
	}

	public void setBook(final Book book) {
		this.book = book;
	}

}
