package question07;

/*
 * Q7. Sort two employees based on their name, department, and age using the Comparator interface.
 */
public class Q07 {

}

class Employee implements Comparable<Employee>{
	String name;
	String department;
	int age;
	Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
