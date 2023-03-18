package ai.neuron.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import ai.neuron.dto.Student;
import ai.neuron.service.IStudentService;
import ai.neuron.servicefactory.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {

			System.out.println("1.CREATE\n2.READ\n3.UPDATE\n4.DELETE\n5.EXIT");
			System.out.println("ENTER YOUR CHOICE,PRESS[1/2/3/4/5]:: ");
			String option = br.readLine();

			switch (option) {

			case "1":
				insertOperation();
				break;
			case "2":
				selectOperation();
				break;
			case "3":
				updateRecord();
				break;
			case "4":
				deleteOperation();
				break;
			case "5":
				System.out.println("*********Thanks for using the application*********");
				System.exit(0);
			default:
				System.out.println("Invalid Option plz try again with valid option");
				break;
			}
		}

	}

	public static void updateRecord() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Student id");
		String id = br.readLine();

		IStudentService studentService = StudentServiceFactory.getstudentServiceObj();
		Student student = studentService.searchStudServ(Integer.parseInt(id));

		if (student != null) {

			Student newStudent = new Student();
			System.out.println("Student id is :: " + student.getSid());
			newStudent.setSid(student.getSid());

			System.out.println("Student old name is :: " + student.getSname() + " Enter the new name:: ");
			String newName = br.readLine();
			if (newName.equals("") || newName == "") {
				newStudent.setSname(student.getSname());
			} else {
				newStudent.setSname(newName);
			}

			System.out.println("Student old age is :: " + student.getSage() + " Enter the new age:: ");
			String newAge = br.readLine();
			if (newAge.equals("") || newAge == "") {
				newStudent.setSage(student.getSage());
			} else {
				newStudent.setSage(Integer.parseInt(newAge));
			}

			System.out.println("Student old address is :: " + student.getSaddress() + " Enter the new address:: ");
			String newAddress = br.readLine();
			if (newAddress.equals("") || newAddress == "") {
				newStudent.setSaddress(student.getSaddress());
			} else {
				newStudent.setSaddress(newAddress);
			}
			System.out.println("new Object data is :: " + newStudent);
			System.out.println();

			String status = studentService.updateStudServ(newStudent);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("record updated succesfully");
			} else {
				System.out.println("record updation failed");
			}

		} else {
			System.out.println("Record not found for the id:: " + id + "for updation");
		}

	}


	public static void deleteOperation() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Student id");
		int id = scan.nextInt();

		IStudentService studentService = StudentServiceFactory.getstudentServiceObj();

		String mssg = studentService.deleteStudServ(id);

		if ("success".equalsIgnoreCase(mssg)) {
			System.out.println("Record deleted successfully!!");
		} else if ("not found".equalsIgnoreCase(mssg)) {
			System.out.println("Record not found for the given id :: " + id);
		} else {
			System.out.println("Record deleted successully");
		}

		
	}

	public static void selectOperation() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Student id");
		int id = scan.nextInt();

		IStudentService studentService = StudentServiceFactory.getstudentServiceObj();
		Student student = studentService.searchStudServ(id);
		if (student != null) {
			System.out.println(student);
			System.out.println("SID/tSNAME/tSAGE/tSADDRESS");
			System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSage() + "\t"
					+ student.getSaddress() + "\t");
		} else {
			System.out.println("Record not found for the given id :: " + id);
		}
		
	}


	public static void insertOperation() {
		IStudentService studentService = StudentServiceFactory.getstudentServiceObj();

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the Student name");
		String name = scan.next();
		System.out.println("Enter the Student age");
		int age = scan.nextInt();
		System.out.println("Enter the Student address");
		String address = scan.next();

		String mssg = studentService.addStudServ(name, age, address);
		if ("Success".equalsIgnoreCase(mssg)) {
			System.out.println("Record inserted successfully");
		} else {
			System.out.println("Record insertion failed");
		}

	
	}

}
