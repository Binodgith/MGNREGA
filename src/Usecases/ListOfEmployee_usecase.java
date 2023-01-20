package Usecases;

import java.util.List;

import Dao.*;
import Exception.EmployeeException;
import Model.Employee;
import Style.ConsoleColors;

public class ListOfEmployee_usecase {
	
	public static void listofemployee() {
		GPMDao dao =new GPMDao_impl();
		
		try {
			List<Employee> emp = dao.ListOfEmployee();
			
			System.out.println("---------------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Employee Present" + ConsoleColors.RESET+ "---------------------------");
			
			System.out.println("---------------------------------------------------------------------------------");
			
			System.out.printf("%7s %7.5s %8.5s %10s %15s %17s %16s",ConsoleColors.BLACK_BOLD + "EID", "EGPMID","EPID", "NAME", "ADDRESS", "DATE JOINED", "WAGE/DAY" + ConsoleColors.RESET);
			System.out.println();
			System.out.print("---------------------------------------------------------------------------------");
			
			System.out.println();
			for(Employee e : emp) {
				
				System.out.format("%2s %6s %8.5s %13s %14s %16s %10s",e.getEid(),e.getEgpmid(),e.getEpid(),e.getEname(),e.getEaddress(),e.geteDate(),e.getEwage());
				System.out.println();
			}
			
			System.out.println("---------------------------------------------------------------------------------");
	
		} catch (EmployeeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
	}

}
