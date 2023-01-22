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
			
			System.out.println();
			System.out.println(ConsoleColors.BOXING+ConsoleColors.BROWN_BACKGROUND+"              Table of all the Employee Present             "+ConsoleColors.RESET);
			
			System.out.println("---------------------------------------------------------------------------------");
			
			System.out.printf("%7s %7.5s %8.5s %10s %15s %17s %16s",ConsoleColors.BROWN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT  + "EID", "EGPMID","EPID", "NAME", "ADDRESS", "DATE JOINED", "WAGE/DAY" + ConsoleColors.RESET);
			System.out.println();
//			System.out.print("---------------------------------------------------------------------------------");
			
			System.out.println();
			for(Employee e : emp) {
				
				System.out.format("%2s %6s %8.5s %13s %14s %16s %10s",e.getEid(),e.getEgpmid(),e.getEpid(),e.getEname(),e.getEaddress(),e.geteDate(),e.getEwage());
				System.out.println();
			}
			
			System.out.println(ConsoleColors.BROWN_BACKGROUND+"--------------------------------------------------"+ConsoleColors.RESET);
	
		} catch (EmployeeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
	}

}
