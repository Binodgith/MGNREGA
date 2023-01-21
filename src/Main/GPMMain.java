package Main;

import Style.ConsoleColors;
import Usecases.CreateEmployee_usecase;
import Usecases.EmployeeDayWages_usecase;
import Usecases.GPMLogin_usecase;
import Usecases.ListOfEmployee_usecase;
import Usecases.AssignProjectToEmployee;

public class GPMMain {
	
	public static void GPMDash() {
		System.out.println();
		System.out.println(ConsoleColors.BOXING+ConsoleColors.CYAN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to Gram Panchayat Member Home Window : "+ ConsoleColors.RESET);
		System.out.println("Press 1 to"+ConsoleColors.CYAN_BRIGHT +" Add a Employee." + ConsoleColors.RESET);
		System.out.println("Press 2 to"+ConsoleColors.CYAN_BRIGHT +" View Detail List of all Employee." + ConsoleColors.RESET);
		System.out.println("Press 3 to"+ConsoleColors.CYAN_BRIGHT +" Assingn Employee to a Project." + ConsoleColors.RESET);
		System.out.println("Press 4 to"+ConsoleColors.CYAN_BRIGHT+" View deatil of all Employees Total wages and Working Days." + ConsoleColors.RESET);
		System.out.println("Press 5 to"+ConsoleColors.CYAN_BRIGHT +" LOGOUT AND RETURN TO HOMEPAGE" + ConsoleColors.RESET);
	}
	
	public static boolean GPMLogin() {
		GPMLogin_usecase  GPMl=new GPMLogin_usecase();
		boolean result=GPMl.gpmlogin();
		return result;
	}
	
	
	public static void CreateEmployee() {
		CreateEmployee_usecase ce=new CreateEmployee_usecase();
		ce.createemployee();
	}
	
	public static void ListOfEmployee() {
		ListOfEmployee_usecase loe=new ListOfEmployee_usecase();
		loe.listofemployee();
	}
	
	public static void AssignProjectToEmployee() {
		AssignProjectToEmployee ape=new AssignProjectToEmployee();
		ape.assignprojectemployee();
	}
	
	public static void EmployeeDayWages() {
		EmployeeDayWages_usecase edw=new EmployeeDayWages_usecase();
		edw.employeedaywage(); 
	}
	

}
