package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IntroToIO {

	public static void main(String[] args) {
		tryWithResources("testing testing testing testing", "src/com/revature/io/test.txt");
		read("src/com/revature/io/test.txt");
	}
	static void writeString(String text, String filepath) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
			bw.write(text);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	
	static void tryWithResources(String text, String filepath) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true))) {
			bw.write(text);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static void read(String filepath) {
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			String currString = null;
			while((currString = br.readLine())!=null) {
				System.out.println(currString);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
