package com.phase1.FirstPage;

import java.util.Scanner;

import com.phase1.UserInputs.MainMenu;

public class ApplicationFirstPage {
		
	public static Scanner in = new Scanner(System.in);
	
    public static void main(String[] args) {    	
    	MainMenu welcome = new MainMenu();
    	welcome.introWS();
    	welcome.GetUserInput();
    }
}
