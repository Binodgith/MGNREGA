package Usecases;

import java.util.List;

import Dao.*;
import Exception.ProjectException;
import Model.Project;
import Style.ConsoleColors;

public class ListAllProject_usecase {
	
	public static void listallproject() {
		
		BDODao dao=new BDODao_impl();
		
		try {
			List<Project> projects = dao.ListOfProject();
			
			
			System.out.println(ConsoleColors.TEAL+"========================================================================="+ConsoleColors.RESET);
			
			System.out.printf("%7s %7.5s %16s %15s %17s",ConsoleColors.TEAL + "PID", "GPMID", "NAME", "COST", "DURATION" + ConsoleColors.RESET);
			System.out.println();
			System.out.print(ConsoleColors.TEAL+"======================================================================"+ConsoleColors.RESET);
			
			System.out.println();
			for(Project p: projects) {
				
				System.out.format("%2s %6s %22s %12s %11s",p.getPid(),p.getPgpmid(), p.getPname(),p.getPcost(),p.getPduration() + " Days");
				System.out.println();
			}
			
			System.out.println(ConsoleColors.TEAL+"===================================================================="+ConsoleColors.RESET);
	
		} catch (ProjectException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
	}

}
