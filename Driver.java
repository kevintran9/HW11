/*	This program will use the class Person that implements Serializable and prompts the user with a menu to write object to file "Person.bin" 
 *  by ObjectOutputStream and ObjectInputStream to read the file
 * 	Homework Assignment: 11 Question 2
 * 	Name: Kevin Tran
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Driver {
	// Function that writes to file "Person.bin" using class object Person passed
	public static void writeToFile(Person p) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Person.bin"));
		oos.writeObject(p);
	}
	
	// Function that reads ObjectInputStream of file "Person.bin" and display toString
	public static void readFile() throws IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Person.bin"));
		Person info = (Person) ois.readObject();
		System.out.println(info);
	}
	
	// Function that prompts user a menu and returns option
	public static int prompt() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 1 to add Person into file");
		System.out.println("Enter 2 to retrieve information from file and display");
		System.out.println("Enter 3 to delete information");
		System.out.println("Enter 4 to update information");
		System.out.println("Enter 5 to exit program");	
		
		int option = sc.nextInt();
		if (option != 1 && option != 2 && option != 3 && option != 4 && option != 5) {
			System.out.println("Invalid input! Try again");
			prompt();
		}
		return option;
	}
	
	// Function that prompts user for needed parameters to create and add to file instance of 'Person'
	public static void addPerson() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = sc.nextLine();
		System.out.println("Enter phone number:");
		int pNumber = sc.nextInt();
		System.out.println("Enter date of birth:");
		String dob = sc.next();
		System.out.println("Enter e-mail:");
		String email = sc.next();
		
		Person p1 = new Person(name, pNumber, dob, email);
		try {
			writeToFile(p1); 
		} catch (IOException e) 
			{ e.printStackTrace(); }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int option = 0;
		
		// Switch statement to loop until user enters 5 to exit
		while (option != 5) {
			option = prompt();
			switch(option) {
			case 1:
				addPerson();
				break;
			case 2:
				try {
					readFile();
				} catch (ClassNotFoundException | IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					new FileOutputStream("Person.bin").close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				addPerson();
				break;
			case 5:
				break;
			}
		}
		System.out.println("Program exit");
	}
}

