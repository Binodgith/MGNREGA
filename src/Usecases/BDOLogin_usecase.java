package Usecases;

import java.util.Scanner;

import Dao.BDODao;
import Dao.BDODao_impl;
import Exception.CredentialException;
import Style.ConsoleColors;

public class BDOLogin_usecase {
	
	public static boolean bdologin()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Phone : ");
		String phone = sc.next();
		
		System.out.println("Enter Password : ");
		String password = sc.next();
		
		BDODao dao = new BDODao_impl();
		
		String result;
		
		try {
			result = dao.BDOLogin(phone, password);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return true;
			
			
		} catch (CredentialException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return false;
		}
		
	}
}
