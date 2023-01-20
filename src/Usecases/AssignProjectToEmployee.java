package Usecases;

import java.util.Scanner;

import Dao.*;
import Exception.EmployeeException;
import Exception.GPMException;
import Exception.ProjectException;
import Style.ConsoleColors;

public class AssignProjectToEmployee {
	
	public static void assignprojectemployee() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Project ID to assign : ");
		int pid = sc.nextInt();
		System.out.println("Enter Employee ID to assign : ");
		int eid = sc.nextInt();
		
		
		GPMDao dao = new GPMDao_impl();
		String result;
		
		try {
			result = dao.AssignProjectToEmployee(pid, eid);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} catch (EmployeeException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} catch (ProjectException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} catch (GPMException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		}
	}

}
