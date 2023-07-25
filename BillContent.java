public class BillContent{
	int no;
	double price;
	String name, qty;
	
	BillContent(int no, String name, String qty, double price){
		this.no = no;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

	@Override
	public String toString() {
		return "BillContent [no=" + no + ", Name=" + name + ", price=" + price + ", qty=" + qty + "]";
	}
}