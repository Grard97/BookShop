package prBookShop;

public class Book {
	private String author;
	private String title;
	private double basePrice;
	private static double IVA = 10;
	
		public Book (String author, String title, double basePrice) {
			this.author = author;
			this.title = title;
			this.basePrice = basePrice;
		}
		
		public String getAuthor() { return this.author;}
		public String getTitle() {return this.title;}
		public double getBasePrice() {return this.basePrice;}
		
		public double amountDue() {
			return basePrice + ((basePrice/IVA)*100);
		}
		
		public String toString() {
			return this.author+"; "+this.title+"; "+ this.basePrice+"; "+ IVA+"; "+amountDue();
		}
		
		public static double getIVA() {
			return IVA;
		}
		
		public static void setIVA(double iva) {
			IVA = iva;
		}
}
