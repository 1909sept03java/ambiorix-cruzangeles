package com.revature;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.AutowiredFlashcard;
import com.revature.model.ConstructorInjectionFlashcard;
import com.revature.model.Flashcard;
import com.revature.model.Topic;

public class Driver {
	
	public static void main(String[] args) {
		// access the ApplicationContext, the IoC container
		// AbstractApplicationContext is an abstract class which implements ApplicationContext
		// ClassPathXmlApplicationContext is a concrete class which extends AbstractApplicationContext
		// provide a constructor with location of XML Spring configuration file
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		// obtain an instance of the Topic bean from the ac
		// argument to getBean() refers to the name given in the Spring configuration
		// (USUALLY.. just the name of the class in calmCase
		Topic t = (Topic) ac.getBean("topicBean");
		System.out.println(t);
		
		// obtain an instance of the Flashcard bean from ac
		Flashcard f = (Flashcard) ac.getBean("flashcardBean");
		System.out.println(f);
		
		ConstructorInjectionFlashcard c = (ConstructorInjectionFlashcard) ac.getBean("constructorInjectionFlashcard");
		System.out.println(c);
		
		AutowiredFlashcard a = (AutowiredFlashcard) ac.getBean("autowiredFlashcard");
		System.out.println(a);
		ac.close();
	}

}
