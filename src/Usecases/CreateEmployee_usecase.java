package Usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Dao.*;
import Exception.EmployeeException;
import Model.Employee;
import Style.ConsoleColors;

public class CreateEmployee_usecase {
	
	public static void createemployee() {
		Scanner sc = new Scanner(System.in);
		
		try {
			
			
			System.out.println("Enter Employee Name : ");
			String name = sc.nextLine();
			
			System.out.println("Enter Employee Phone Number : ");
			String phone = sc.nextLine();
//			sc.nextLine();
			System.out.println("Enter Employee Address : ");
			String address = sc.nextLine();
			
			System.out.println("Enter Employee Wage/day : ");
			int wage = sc.nextInt();
			
			Employee e = new Employee();
			e.setEaddress(address);
			e.setEname(name);
			e.setEwage(wage);
			e.setEphone(phone);
			
			GPMDao dao = new GPMDao_impl();
			String result;
			
			try {
				result = dao.CreateEmployee(e);
				System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);

			} catch (EmployeeException emp) {
				result = emp.getMessage();
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			
			}
			
		} catch (InputMismatchException i) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
		}
	}

}
