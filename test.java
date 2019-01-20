package Candidates_Of_Company1;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.Scanner;

public class test {

	private Scanner input = new Scanner(System.in);

	InternCandidate intern1 = new InternCandidate();
	FresherCandidates fresher1 = new FresherCandidates();
	ExperienceCandidates experience1 = new ExperienceCandidates();
	


	public void menu() {
		int choose=0;
		while(true) {

			try {
				System.out.println("=========================================");
				System.out.println("CANDIDATE MANAGEMENT SYSTEM:");
				System.out.println("1.Experience");
				System.out.println("2.Fresher");
				System.out.println("3.Internship");
				System.out.println("4.Searching");
				System.out.println("5.Exit");
				
				System.out.println("Please choose 1 to create experience candidates, "
						+ "2 to create fresher cadidates, 3 to create intern candidates,"
						+ " 4 to searching, t to exit");
				System.out.println("=========================================");
				input = new Scanner(System.in);
				choose = input.nextInt();
				 
				
			} catch (Exception e) {
				System.out.println("you are wrong!. Please try again!");
				
			}
			
			switch (choose) {
			
				case 1:
					createExperience();
					break;
				case 2:
					creareFresher();
					break;
				case 3:
					createIntern();
					break;
				case 4:
					searching();
					break;
				case 5:
					System.exit(0);
					break;
			
				default:
					break;
				}
			
		}
			
	}
		
	
	

	
	
	private void searching() {
		int type ;

		experience1.printList();
		fresher1.printList();
		intern1.printList();
		System.out.println("=========================================");
		System.out.println("Enter CANDIDATE NAME: ");
		input = new Scanner(System.in);
		String name = input.nextLine();
		
		while(true) {
			try {
				System.out.println("Enter TYPE OF CANDIDATE(0,1,2): ");
				input = new Scanner(System.in);
				type = input.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Remember typing number!");
			}
			
		}
		System.out.println("=========================================");
		System.out.println("=====       Candidate Found :        ==== ");
		System.out.println("=========================================");
		experience1.searching(name, type);
		fresher1.searching(name, type);
		intern1.searching(name, type);
	
	}


	private void createIntern() {
		intern1 = new InternCandidate();
		intern1.getInfor();
		
	}


	private void creareFresher() {
		fresher1 = new FresherCandidates();
		fresher1.getInfor();
		
	}


	private void createExperience() {
		experience1 = new ExperienceCandidates();
		experience1.getInfor();

	}






	public static void main(String[] args) {
		 test t = new test();
		 t.menu();


		
	}

}
