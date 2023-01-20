package Usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Dao.*;
import Exception.ProjectException;
import Model.Project;
import Style.ConsoleColors;

public class CreateProject_usecase {
	
	public static void createproject() {
		Scanner sc = new Scanner(System.in);
		
		try {
			
			
			System.out.println("Enter Project Name : ");
			String name = sc.nextLine();
			System.out.println("Enter Project Cost : ");
			int cost = sc.nextInt();
			System.out.println("Enter Project Duration :");
			int duration = sc.nextInt();
			
			Project p = new Project();
			p.setPname(name);
			p.setPcost(cost);
			p.setPduration(duration);
			
			BDODao dao = new BDODao_impl();
			String result;
			
			try {
				result = dao.CreateProject(p);
				System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);


			} catch (ProjectException e) {
				result = e.getMessage();
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);

			}
			
		} catch (InputMismatchException i) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
		}
		
	}

}
