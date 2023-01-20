package Usecases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Dao.*;
import Exception.BDOException;
import Exception.GPMException;
import Exception.ProjectException;
import Style.ConsoleColors;
import Utility.Utility;

public class AllocateProjectToGPM {
	
	public static void  allocateprojecttogpm() {
		
		Scanner input=new Scanner(System.in);
		System.out.println("----------Assign Project to Gram panchayat member.---------");
		
		System.out.println("Enter Project ID :");
		int pid=input.nextInt();
		
		System.out.println("Enter GPM ID :");
		int gpmid=input.nextInt();
		
		BDODao dao=new BDODao_impl();
		
		try {
			String result=dao.AllocateProjectToGPM(pid, gpmid);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			
		}
		catch(ProjectException e) {
			String result=e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} 
		catch (GPMException e) {
			String result=e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} 
		catch (BDOException e) {
			String result=e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		}
	}

}
