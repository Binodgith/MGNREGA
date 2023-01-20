package Usecases;

import java.util.List;
import java.util.Scanner;

import Dao.*;
import Exception.BDOException;
import Exception.EmployeeException;
import Exception.ProjectException;
import Model.Employee;
import Style.ConsoleColors;

public class EmployeeOnProject_usecase {
	
	public static void emplyeeonproject() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Project ID to see the list of all employeein that project : ");
		int pid = sc.nextInt();
		
		
		BDODao dao = new BDODao_impl();
		
		try {
			List<Employee> emp =  dao.EmployeeOnProject(pid);
			
			System.out.println("--" + ConsoleColors.TEAL_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT +"Table of all the Employee Present in the Project ID : " +pid + ConsoleColors.RESET+ "----");
			
			System.out.println(ConsoleColors.TEAL+"=============================================="+ConsoleColors.RESET);
			
			System.out.printf("%17s %10.5s %19s",ConsoleColors.TEAL + "EID","NAME","WAGE/DAY"  +ConsoleColors.RESET);
			System.out.println();
			System.out.print(ConsoleColors.TEAL+"=============================================="+ConsoleColors.RESET);
			
			System.out.println();
			for(Employee e : emp) {
				
				System.out.format("%9.2s %13s %10s",e.getEid(),e.getEname(),e.getEwage());
				System.out.println();
			}
			
			System.out.println(ConsoleColors.TEAL+"=============================================="+ConsoleColors.RESET);
			
			
			
			
		} catch (ProjectException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		} catch (EmployeeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		} catch (BDOException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}				
	}

}
