package prBookShop;

public class BookShop {
	
	private int numBooks = 0;
	private Book bookArr [];
	private final int arrDefaultSize = 16;

	public BookShop () {
		 this.bookArr = new Book [this.arrDefaultSize];
	}
	
	public void addBook(String author, String title, double price) {
		Book newBook = new Book(author, title, price);
		int i = 0;
		while (author != this.bookArr[i].getAuthor()  && title != this.bookArr[i].getTitle() && i< numBooks) {
			++i;
		}

		if (i == numBooks) {
			System.arraycopy(this.bookArr, 0, this.bookArr, 0, numBooks*2); 
			this.bookArr[numBooks+1] = newBook; 
			numBooks++;
			}
		else {
			this.bookArr[i] = newBook;
		} 
	}
	
	
	public void deleteBook(String author, String title) {
		deleteBook(seekBook(author, title));
	}
	public double getBasePrice(String author, String title) {
		int book = seekBook(author, title);
		return	this.bookArr[book].getBasePrice();
	}
	
	
	private int seekBook (String author, String title) {
		int res, i = 0;
		while (author != this.bookArr[i].getAuthor() && title != this.bookArr[i].getTitle() && i < numBooks) {
			++i;
		}
		if (i < numBooks) res = i;
		else res = -1;
		return res;
	}
	
	private void deleteBook(int book) {
		this.bookArr[book] = this.bookArr[numBooks];
		this.bookArr[numBooks] = null;
		numBooks--;
	}
	
	public double amountDue(String author, String title) {
		double res;
		int book = seekBook(author, title);
		if (book != -1) res = this.bookArr[book].amountDue();
		else res = 0;
		return res;
	}
	
	public String toString() {
		String res = "";
		int i = 0;
		while (i<numBooks) {
			res += this.bookArr[i].toString() + ", \n";
		}
		return res;
	}
	
}
