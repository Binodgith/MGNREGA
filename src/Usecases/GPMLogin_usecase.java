package Usecases;
import java.util.Scanner;

import Dao.*;
import Exception.CredentialException;
import Exception.GPMException;
import Style.ConsoleColors;
public class GPMLogin_usecase {
	
	public static Boolean gpmlogin() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Registered Phone Number to LogIn : ");
		String phone = sc.nextLine();
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		
		
		
		GPMDao dao = new GPMDao_impl();
		 
		String result;
		
		try {
			result= dao.GMPLogin(phone, password);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return true;
			
		} catch (CredentialException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return false;
		} catch (GPMException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return false;
		}
		
	}
}
