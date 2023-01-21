package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

import Style.ConsoleColors;
import Usecases.*;

public class Main {
	
	public static void main(String[] args) {
		HomeDash();
		
//		BDOLogin_usecase bl=new BDOLogin_usecase();
//		bl.bdologin();
		
//		CreateProject_usecase cp=new CreateProject_usecase();
//		cp.createproject();
		
		
//		ListAllProject_usecase lp=new ListAllProject_usecase();
//		lp.listallproject();
		
//		CreateGpm_usecase cgpm=new CreateGpm_usecase();
//		cgpm.creategpm();
		
		
//		ListAllGPM lg= new ListAllGPM();
//		lg.listofgpm();
		
//		AllocateProjectToGPM apg=new AllocateProjectToGPM();
//		apg.allocateprojecttogpm();
		
		
//		EmployeeOnProject_usecase ep=new EmployeeOnProject_usecase();
//		ep.emplyeeonproject();
		
		
//		GPMLogin_usecase gpml=new GPMLogin_usecase();
//		gpml.gpmlogin();
		
		
//		CreateEmployee_usecase cp=new CreateEmployee_usecase();
//		cp.createemployee();
		
		
//		ListOfEmployee_usecase loe=new ListOfEmployee_usecase();
//		loe.listofemployee();
		
		
//		AssignProjectToEmployee ape=new AssignProjectToEmployee();
//		ape.assignprojectemployee();
		
		
//		EmployeeDayWages_usecase edw=new EmployeeDayWages_usecase();
//		edw.employeedaywage();
		
		
		
		
	}
	
	
	
	public static void HomeDash() throws InputMismatchException{
		
		try {
			
			System.out.println(ConsoleColors.BOXING+ConsoleColors.CYAN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to MGNREGA : "+ ConsoleColors.RESET);
			System.out.println();
			System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Choose Option from Below According to your Designation  : " + ConsoleColors.RESET);
			System.out.println("Press 1 to" +ConsoleColors.CYAN_BRIGHT + " logIn as BDO." + ConsoleColors.RESET);
			System.out.println("Press 2 to" +ConsoleColors.CYAN_BRIGHT + " logIn as Gram Panchayat Member."+ ConsoleColors.RESET);
			System.out.println("Press 3 to" +ConsoleColors.CYAN_BRIGHT +" EXIT."+ ConsoleColors.RESET);
			
			Scanner input=new Scanner(System.in);
			
			String choice=input.nextLine();
			
			if(choice.equals("1")) {
				
				BDOMain bdo=new BDOMain();
				boolean res=bdo.BDOLogin();
				
				while(!res) {
					res=bdo.BDOLogin();
					
					if(res) {
						break;
					}
				}
				
				if(res) {
					
					while(true) {
						bdo.BDODash();
						
						String bdochoice=input.nextLine();
						
						if(bdochoice.equals("1"))
							while(true) {
								bdo.CreateProject();
								System.out.println("Do you want to add More : y/n");
								String radio=input.nextLine();
								if(radio.equals("n") || radio.equals("N")) {
									break;
								}
							}
							
						
						else if(bdochoice.equals("2")) bdo.ListAllProject();
						
						else if(bdochoice.equals("3"))
							while(true) {
								bdo.CreateGPM();
								System.out.println("Do you want to add More : y/n");
								String radio=input.nextLine();
								if(radio.equals("n") || radio.equals("N")) {
									break;
								}
							}
							
							
						
						else if(bdochoice.equals("4")) bdo.ListAllGPM();
						
						else if(bdochoice.equals("5")) bdo.AllocateProjectToGPM();
						
						else if(bdochoice.equals("6")) bdo.EmployeeOnProject();
						
						else if(bdochoice.equals("7")) {
							System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "LOGOUT SUCCESSFUL !" + ConsoleColors.RESET);
							break;
						}
						else System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "CHOOSE CORRECT INPUT RANGE FROM 1 TO 7" + ConsoleColors.RESET);
						System.out.println();
					}
					HomeDash();
				}
			}
			
			else if(choice.equals("2")) {
				GPMMain gpm=new GPMMain();
				boolean res=gpm.GPMLogin();
				

				while(!res) {
					res=gpm.GPMLogin();
					
					if(res) {
						break;
					}
				}
				
				if(res) {
					
					while(true) {
						gpm.GPMDash();
						
						String bdochoice=input.nextLine();
						
						if(bdochoice.equals("1"))
							while(true) {
								gpm.CreateEmployee();
								System.out.println("Do you want to add More : y/n");
								String radio=input.nextLine();
								if(radio.equals("n") || radio.equals("N")) {
									break;
								}
							}
							
						
						else if(bdochoice.equals("2")) gpm.ListOfEmployee();
						
						else if(bdochoice.equals("3")) gpm.AssignProjectToEmployee();
						
						else if(bdochoice.equals("4")) gpm.EmployeeDayWages();
						
						else if(bdochoice.equals("5")) {
							System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "LOGOUT SUCCESSFUL !" + ConsoleColors.RESET);
							break;
						}
						else System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "CHOOSE CORRECT INPUT RANGE FROM 1 TO 7" + ConsoleColors.RESET);
						System.out.println();
					}
					HomeDash();
				}
				
			}
			else if(choice.equals("3")) {
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "APPLICATION CLOSED : EXITED" + ConsoleColors.RESET);
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Thanks for Visiting" + ConsoleColors.RESET);
				System.exit(0);
			}
			else {
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "CHOOSE CORRECT INPUT RANGE FROM 1 TO 3" + ConsoleColors.RESET);
				HomeDash();
				
			}
			System.out.println();
			
			
		}
		catch(InputMismatchException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
	}

}
