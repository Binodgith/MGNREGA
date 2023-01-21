package Usecases;

import java.util.List;

import Dao.*;
import Exception.GPMException;
import Model.GPM;
import Style.ConsoleColors;

public class ListAllGPM {
	
	public static void listofgpm() {
		BDODao dao = new BDODao_impl();
		
		try {
			List<GPM> gpmList = dao.ListOfGPM();
			
			System.out.println();
			System.out.println(ConsoleColors.BOXING+ConsoleColors.BROWN_BACKGROUND+"              Table of all Gram Panchayat Member Present             "+ConsoleColors.RESET);

			
//			System.out.println(ConsoleColors.TEAL+"======================================================================"+ConsoleColors.RESET);
			
			System.out.printf("%7s %12s %16s %12.5s %19s",ConsoleColors.BROWN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT + "GPID", "NAME", "ADDRESS", "PHONE", "PASSWORD" + ConsoleColors.RESET);
			System.out.println();
//			System.out.print(ConsoleColors.TEAL+"====================================================================="+ConsoleColors.RESET);
			
			System.out.println();
			for(GPM g : gpmList) {
				
				System.out.format("%2s %15s %14s %15s %14s",g.getGpmid(),g.getGpmname(),g.getGpmaddress(),g.getGpmphone(),g.getGpmpassword());
				System.out.println();
			}
			
			System.out.println(ConsoleColors.BROWN_BACKGROUND+"--------------------------------------------------------------"+ConsoleColors.RESET);

			
		} catch (GPMException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
	}

}
