package com.revature.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UnderstandingCollections {

	public static void main(String[] args) {
		setTree();
	}
	
	static void setHash() {
		/*
		 * HashSet does not keep track of the order
		 * that the elements are adding in.
		 * completely random.
		 */
		Set<String> myHashSet = new HashSet<String>();
		myHashSet.add("Hello"); 				 			   // 1
		myHashSet.add("my");    				 			   // 2
		myHashSet.add("name");  				 			   // 3
		myHashSet.add("ERROR");				 	 			   // 4
		myHashSet.add("is");    				 			   // 5
		myHashSet.add("is");    				 			   // 5 - is a duplicate, doesn't get added
		System.out.println(myHashSet.add("is")); 			   // 5 - adding another is, returns false
		myHashSet.add("Rex");   				 			   // 6
		System.out.println(myHashSet.size());    			   // prints out 6
		myHashSet.remove("ERROR"); 				 			   // removing the ERROR
		System.out.println(myHashSet.size()); 	 			   // prints out 5
		Iterator<String> myHashSetIterator = myHashSet.iterator(); // creating and setting my cursor
		while(myHashSetIterator.hasNext()) { 				   // if there exists another element
			System.out.println(myHashSetIterator.next());      // iterating through myHashSet with my cursor
		}
	}
	
	static void setTree() {
		/*
		 * 
		 */
		Set<String> myTreeSet = new TreeSet<String>();
		myTreeSet.add("Hello"); 				 			   // 1
		myTreeSet.add("my");    				 			   // 2
		myTreeSet.add("name");  				 			   // 3
		myTreeSet.add("ERROR");				 	 			   // 4
		myTreeSet.add("is");    				 			   // 5
		myTreeSet.add("is");    				 			   // 5 - is a duplicate, doesn't get added
		System.out.println(myTreeSet.add("is")); 			   // 5 - adding another is, returns false
		myTreeSet.add("Rex");   				 			   // 6
		System.out.println(myTreeSet.size());    			   // prints out 6
		myTreeSet.remove("ERROR"); 				 			   // removing the ERROR
		System.out.println(myTreeSet.size()); 	 			   // prints out 5
		Iterator<String> myTreeSetIterator = myTreeSet.iterator(); // creating and setting my cursor
		while(myTreeSetIterator.hasNext()) { 				   // if there exists another element
			System.out.println(myTreeSetIterator.next());      // iterating through myHashSet with my cursor
		}
	}
	
	static void listLinked() {
		/*
		 * A list is an ordered collection
		 * it can have duplicates
		 * things can be added at any index
		 * 
		 * the output of the sysout should be the 
		 * string backwards because it was added
		 * to the front of the list, every time
		 */
		List<String> myLinkedList = new LinkedList<String>();
		myLinkedList.add("Hello");
		myLinkedList.add(0, "my"); // placing them at the beginning
		myLinkedList.add(0, "name");
		myLinkedList.add(0, "is");
		myLinkedList.add(0, "Rex");
		myLinkedList.add(0, "Rex");
		System.out.println(myLinkedList.size());
		Iterator<String> myLinkedListIterator = myLinkedList.iterator();
		while(myLinkedListIterator.hasNext()) {
			System.out.println(myLinkedListIterator.next().toUpperCase()); // should be backwards
		}
	}
	
}
