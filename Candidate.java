package Candidates_Of_Company1;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Pattern;

import Generics.interandsub;

public class Candidate {
	
	//: CandidateId, FirstName, LastName, BirthDate, Address, Phone, Email andCandidatetype. 
	protected String candidateid;
	protected String firstName;
	protected String lastName;
	protected String birthday;
	protected String address;
	protected String phone;
	protected String email = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	protected int candidateType;
	protected String checkcontinue;
	Scanner input = new Scanner(System.in);

	
	public Candidate(String candidateid, String firstName, String lastName, String birthday, String address,
			String phone, String email, int candidateType) {
		super();
		this.candidateid = candidateid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.candidateType = candidateType;
	}

	public Candidate() {
		super();
	}

	public String getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(String candidateid) {
		this.candidateid = candidateid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCandidateType() {
		return candidateType;
	}

	public void setCandidateType(int candidateType) {
		this.candidateType = candidateType;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.firstName + this.lastName;
	}
	
	
	public <T extends Candidate> void  output( T anonymous ) {
		

		
		System.out.println("Enter ID: ");
		candidateid = input.nextLine();
		anonymous.setCandidateid(candidateid);
		
		System.out.println("Enter FIRSTNAME: ");
		firstName = input.nextLine();
		anonymous.setFirstName(firstName);
		System.out.println("Enter LASTNAME: ");
		lastName = input.nextLine();
		anonymous.setLastName(lastName);
		
		
		validateBirthday(birthday,anonymous );
		
		System.out.println("Enter ADDRESS:");
		address = input.nextLine();
		anonymous.setAddress(address);
		validatePhone(phone,anonymous);
		
		validateEmail(email, anonymous);
		
		while(true) {
			try {
				Scanner loop = new Scanner(System.in);
				System.out.println("Enter CANDIDATE TYPE: ");
				System.out.println("0.Experience");
				System.out.println("1.Fresher");
				System.out.println("2.Intern");
				candidateType = loop.nextInt();
				anonymous.setCandidateType(candidateType);
				
				
				break;
			} catch (Exception e) {
				System.out.println("Remember entering number !\n");
			}
		}
	
		
		
		
	}


	private <T extends Candidate>void validateEmail(String email, T candidate1) {

		
		System.out.println("Enter EMAIL: ");
		email = input.nextLine();
		
		if(Pattern.matches(this.email, email)) {
			candidate1.setEmail(email);
			
		}else {
			
			System.out.println("Please enter again email!");
			validateEmail(email,candidate1);
			
		}
	}


	private <T extends Candidate>void validatePhone(String phone, T candidate1) {
		
		System.out.println("Enter PHONE: ");
		phone = input.nextLine();
		if(isnumberic(phone) && phone.length()>=10) {
			candidate1.setPhone(phone);
			
		}else {
			System.out.println("Please enter again phone number!");
			validatePhone(phone, candidate1);
			
		}
		
		
	}

	private <T extends Candidate>void validateBirthday(String birthday, T candidate1) {
		
		
			System.out.println("Enter BIRTHDAY: ");
			birthday = input.nextLine();
			if(isnumberic(birthday) && birthday.length() == 4 ) {
				candidate1.setBirthday(birthday);
			
			}
			else {
				System.out.println("you are wrong. Please enter birthday again! ");
				validateBirthday(birthday, candidate1);
			}

		
	}

	private boolean isnumberic(String birthday) {

		try {
			
			double d = Double.parseDouble(birthday);
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	

}

class ExperienceCandidates extends Candidate{
	
	protected int experienceYear;
	protected String professinalSkill;
	ArrayList<ExperienceCandidates>  listExperience = new ArrayList<ExperienceCandidates>();
	
	
	public ExperienceCandidates(String candidateid, String firstName, String lastName, String birthday, String address,
			String phone, String email, int candidateType, int experienceYear, String professinalSkill) {
		super(candidateid, firstName, lastName, birthday, address, phone, email, candidateType);
		this.experienceYear = experienceYear;
		this.professinalSkill = professinalSkill;
	}

	public ExperienceCandidates() {
		super();
	}

	public int getExperienceYear() {
		return experienceYear;
	}

	public void setExperienceYear(int experienceYear) {
		this.experienceYear = experienceYear;
	}

	public String getProfessinalSkill() {
		return professinalSkill;
	}

	public void setProfessinalSkill(String professinalSkill) {
		this.professinalSkill = professinalSkill;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
		
	public void getInfor() {
		while(true){
			
			ExperienceCandidates experience1 = new ExperienceCandidates();
			
			super.output(experience1);
			
			while(true) {
				
				try {
					System.out.println("Enter EXPERIENCE YEAR(number): ");
					input = new Scanner(System.in);
					experienceYear = input.nextInt();
					if(experienceYear >=1 && experienceYear <=100) {
						experience1.setExperienceYear(experienceYear);
						break;
						
					}else {
						System.out.println("Birthday must be between 1 and 100");
					}
			
				} catch (Exception e) {
					System.out.println("You are wrong!. Please try again!");
					
				}
			}
				
			
			
			System.out.println("Enter PROFESSIONAL SKILL: ");
			input = new Scanner(System.in);
			professinalSkill = input.nextLine();
			experience1.setProfessinalSkill(professinalSkill);
			listExperience.add(experience1);
			
			System.out.println("Do you want to continue? (y/n)");
			input = new Scanner(System.in);
			String check = input.nextLine();
			if(check.equalsIgnoreCase("y")) {
				continue;
			}else {
				break;
			}
			
		}
		
		

	
	}
	protected void searching(String name, int type) {
		
		
		for(ExperienceCandidates exp : listExperience) {
			if(exp.getFirstName().contains(name)||exp.getLastName().contains(name)&& type == 0) {
			
				System.out.println(exp.getFirstName() + "|"+exp.getLastName()+"|"+exp.getBirthday()+
						"|"+exp.getAddress()+"|"+exp.getPhone()+"|"+exp.getEmail()+"|"+exp.getCandidateType());
			}
			
		}
		
		
	}
	protected void printList() {
		System.out.println("=========================================");
		System.out.println("EXPERIENCE CANDIDATES: ");
		for(ExperienceCandidates ex: listExperience) {
			System.out.println(ex);
		}
		
	}
	
	private void validateExperienceYear(int experienceYear, ExperienceCandidates experience1) {
			
			
			if(experienceYear > 1 && experienceYear<100) {
				experience1.setExperienceYear(experienceYear);
			}else {
				System.out.println("Please try again!");
			}
		
	}

}



class FresherCandidates extends Candidate{
	
	private String graduationTime;
	private String graduationRank;
	private String school;
	private ArrayList<FresherCandidates> listFresher = new ArrayList<FresherCandidates>() ;
	
	public FresherCandidates(String candidateid, String firstName, String lastName, String birthday, String address,
			String phone, String email, int candidateType, String graduationTime, String graduationRank,
			String school) {
		super(candidateid, firstName, lastName, birthday, address, phone, email, candidateType);
		this.graduationTime = graduationTime;
		this.graduationRank = graduationRank;
		this.school = school;
	}

	public FresherCandidates() {
		super();
	}

	public String getGraduationTime() {
		return graduationTime;
	}

	public void setGraduationTime(String graduationTime) {
		this.graduationTime = graduationTime;
	}

	public String getGraduationRank() {
		return graduationRank;
	}

	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	protected void getInfor() {
		
		while(true) {
			
			FresherCandidates fresher1 = new FresherCandidates();
			super.output(fresher1);
			
			
			System.out.println("Enter GRADUATION TIME: ");
			graduationTime = input.nextLine();
			fresher1.setGraduationTime(graduationTime);
			
			while(true) {
				System.out.println("Enter GRADUATION RANK: ");
				System.out.println("One of four values:	(Excellent, Good, Fair, Poor)");
				graduationRank = input.nextLine();
				
				if(graduationRank.equalsIgnoreCase("excellent")||graduationRank.equalsIgnoreCase("good")||
						graduationRank.equalsIgnoreCase("fair")||graduationRank.equalsIgnoreCase("poor")){
							fresher1.setGraduationRank(graduationRank);
							break;
					}
				else {
					System.out.println("There are something wrong!. Please try again! ");
					
				}
			}
				
				System.out.println("Enter NAME OF YOUR SCHOOL: ");
				school = input.nextLine();
				fresher1.setSchool(school);
				listFresher.add(fresher1);
				
	
				
				System.out.println("Do you want to continue(y/n)?");
				checkcontinue = input.nextLine();
				
				if(checkcontinue.equalsIgnoreCase("y")) {		
					continue;
				}
				else {
					break;
				}
			}

		
	}
	protected void printList() {
		System.out.println("=========================================");
		System.out.println("FRESHER CANDIDATES: ");
		for(FresherCandidates fre: listFresher) {
			System.out.println(fre);
		}
		
	}
	
	protected void searching(String name, int type) {
			

			for(FresherCandidates fres : listFresher) {
				if(fres.getFirstName().contains(name)||fres.getLastName().contains(name)&& type == 1) {
				
					System.out.println(fres.getFirstName() + "|"+fres.getLastName()+"|"+fres.getBirthday()+
							"|"+fres.getAddress()+"|"+fres.getPhone()+"|"+fres.getEmail()+"|"+fres.getCandidateType());
				}
				
			}
			
			
		}
		

		
}
class InternCandidate extends Candidate{
	
		private String major;
		private String semester;
		private String school;
		private ArrayList<InternCandidate> listIntern = new ArrayList<InternCandidate>();
		
		public InternCandidate(String candidateid, String firstName, String lastName, String birthday, String address,
				String phone, String email, int candidateType, String major, String semester, String school) {
			super(candidateid, firstName, lastName, birthday, address, phone, email, candidateType);
			this.major = major;
			this.semester = semester;
			this.school = school;
		}


		public InternCandidate() {
			super();
		}

		public String getMajor() {
			return major;
		}


		public void setMajor(String major) {
			this.major = major;
		}


		public String getSemester() {
			return semester;
		}


		public void setSemester(String semester) {
			this.semester = semester;
		}


		public String getSchool() {
			return school;
		}


		public void setSchool(String school) {
			this.school = school;
		}
		
		@Override
		public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
		}
		
		protected void getInfor() {
			while(true) {
				InternCandidate intern1 = new InternCandidate();
				
				super.output(intern1);
				
				System.out.println("Enter MAJOR: ");
				major = input.nextLine();
				intern1.setMajor(major);
				
				System.out.println("Enter SEMESTER: ");
				semester = input.nextLine();
				intern1.setSemester(semester);
				System.out.println("Enter SCHOOLNAME: ");
				school = input.nextLine();
				intern1.setSchool(school);
				listIntern.add(intern1);
				System.out.println("Do you want to continue?(y/n)");
				String check = input.nextLine();
				if(check.equalsIgnoreCase("y")) {
					continue;
				}else {
					break;
				}

			}
		}
		
		protected void printList() {
			System.out.println("=========================================");
			System.out.println("INTERN CANDIDATES: ");
			for(InternCandidate in: listIntern) {
				
				System.out.println(in);
			}
			
		}
			
		protected void searching(String name, int type) {
				
				
				
				for(InternCandidate inter : listIntern) {
					if(inter.getFirstName().contains(name)||inter.getLastName().contains(name)&& type == 2) {
					
						System.out.println(inter.getFirstName() + "|"+inter.getLastName()+"|"+inter.getBirthday()+
								"|"+inter.getAddress()+"|"+inter.getPhone()+"|"+inter.getEmail()+"|"+inter.getCandidateType());
					}
					
				}
				
				
			}
		
	
	
}
