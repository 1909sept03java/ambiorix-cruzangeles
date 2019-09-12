package question07;

import java.util.Comparator;

/*
 * Q7. Sort two employees based on their name, department, and age using the Comparator interface.
 */
public class Q07 {

}

class Employee implements Comparator<Employee>{
	String name;
	String department;
	String age;
	
	public Employee(String name, String department, String age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	@Override
	public int compare(Employee o1, Employee o2) {
		// for comparison 
		
        int nameCompare = o1.name.compareTo(o2.name);
        int deptCompare = o1.department.compareTo(o2.department); 
        int ageCompare = o1.age.compareTo(o2.age);
        return 0;
	}
}
