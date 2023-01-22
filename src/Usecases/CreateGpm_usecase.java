package Usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Dao.*;
import Exception.GPMException;
import Model.GPM;
import Style.ConsoleColors;

public class CreateGpm_usecase {
	
	public static void creategpm() {
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println(ConsoleColors.BOXING+ConsoleColors.BROWN_BACKGROUND+"          Add a new Gram Panchayat Member          "+ConsoleColors.RESET);
			System.out.println("Enter Gram Panchayat Member Name : ");
			String name = sc.nextLine();
			
			System.out.println("Enter Gram Panchayat Member Address : ");
			String address = sc.nextLine();
			
			System.out.println("Enter Gram Panchayat Member Phone Number : ");
			long phNumber = sc.nextLong();
			sc.nextLine();
			String phone = Long.toString(phNumber);
			
			System.out.println("Enter Gram Panchayat Member Password : ");
			
			System.out.println(ConsoleColors.YELLOW_ITALIC+"(Password must contain 8 characters and should have atleast 1 Upper Case, 1 Small Case, 1 Number and 1 Special Character)"+ ConsoleColors.RESET);
			boolean flag = false;
			String password = null;
			while(!flag) {
				password = sc.nextLine();
				flag = password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
				
				if(flag) {
					break;
				}
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Invalid Password Pattern" + ConsoleColors.RESET);
				System.out.println(ConsoleColors.RED_ITALIC+"(Password must contain 8 characters and should have atleast 1 Upper Case, 1 Small Case, 1 Number and 1 Special Character)"+ ConsoleColors.RESET);
			}
			
			
			
			GPM g = new GPM();
			g.setGpmname(name);
			g.setGpmaddress(address);
			g.setGpmphone(phone);
			g.setGpmpassword(password);
			
			BDODao dao = new BDODao_impl();
			String result;
			
			
			try {
				result = dao.CreatGPM(g);
				System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			} catch (GPMException e) {
				result = e.getMessage();
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			}	
			
		} catch (InputMismatchException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
		}
	}

}
