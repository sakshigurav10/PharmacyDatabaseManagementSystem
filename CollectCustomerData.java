public class CollectCustomerData{
	
	String email, name, phno, add, gender;
	int age;
	
	CollectCustomerData(String email, String name, String phno, String add, String gender, int age){
		this.email = email;
		this.name = name;
		this.phno = phno;
		this.add = add;
		this.gender = gender;
		this.age = age;
	}

	public String toString() {
		return "CollectCustomerData [email=" + email + ", name=" + name + ", phno=" + phno + ", add=" + add + ", gender=" + gender + ", age=" + age + "]";
	}
	
}