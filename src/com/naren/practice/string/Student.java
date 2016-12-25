package com.naren.practice.string;

public class Student {
	
	private int ID;
	private String fullName;
	
	public Student(int ID) {
		this.ID = ID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", fullName=" + fullName + "]";
	}

	public static void main(String args[]){
		
		Student s1 = new Student(10010);
			s1.setFullName("Harika Kaki");
		
		Student s2 = new Student(10011);
			s2.setFullName("Vatsalya Battula");
			
			System.out.println(s1.toString() +", " + s2.toString());
		
	}

}
