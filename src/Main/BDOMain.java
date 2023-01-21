package Main;

import Style.ConsoleColors;
import Usecases.*;

public class BDOMain {
	
	
	public static void BDODash() {
		System.out.println();
		System.out.println(ConsoleColors.BOXING+ConsoleColors.CYAN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to BDO Dashboard : "+ ConsoleColors.RESET);
		System.out.println("Press 1 to"+ConsoleColors.CYAN_BRIGHT +" Create a Project." + ConsoleColors.RESET);
		System.out.println("Press 2 to"+ConsoleColors.CYAN_BRIGHT +" View List of all Projects." + ConsoleColors.RESET);
		System.out.println("Press 3 to"+ConsoleColors.CYAN_BRIGHT +" Add a Gram Panchayat Member." + ConsoleColors.RESET);
		System.out.println("Press 4 to"+ConsoleColors.CYAN_BRIGHT+" View List of all Gram Panchayat Members ." + ConsoleColors.RESET);
		System.out.println("Press 5 to"+ConsoleColors.CYAN_BRIGHT +" Allocate Project to Gram Panchayat Member." + ConsoleColors.RESET);
		System.out.println("Press 6 to"+ConsoleColors.CYAN_BRIGHT +" View the List of Employee working on a project" + ConsoleColors.RESET);
		System.out.println("Press 7 to"+ConsoleColors.CYAN_BRIGHT +" LOGOUT AND RETURN TO HOMEPAGE" + ConsoleColors.RESET);	
	}
	
	
	public static boolean BDOLogin() {
		BDOLogin_usecase bl=new BDOLogin_usecase();
		boolean result =bl.bdologin();
		
		return result;
	}
	
	public static void CreateProject() {
		CreateProject_usecase cp=new CreateProject_usecase();
		cp.createproject();
	}
	
	public static void ListAllProject() {
		ListAllProject_usecase lop=new ListAllProject_usecase();
		lop.listallproject();
	}
	
	public static void CreateGPM() {
		CreateGpm_usecase cgpm=new CreateGpm_usecase();
		cgpm.creategpm();
	}
	
	public static void ListAllGPM() {
		ListAllGPM logpm=new ListAllGPM();
		logpm.listofgpm();
	}
	
	public static void AllocateProjectToGPM() {
		AllocateProjectToGPM apGPM=new AllocateProjectToGPM();
		apGPM.allocateprojecttogpm();
	}
	
	public static void EmployeeOnProject() {
		EmployeeOnProject_usecase eop=new EmployeeOnProject_usecase();
		eop.emplyeeonproject();
	}
	
	 

}
