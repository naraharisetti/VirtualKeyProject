package com.phase1.UserInputs;

import java.util.ArrayList;
import com.phase1.FirstPage.ApplicationFirstPage;
import com.phase1.ManageFiles.FileHandling;

public class MainMenu implements Screen {

    private String welcomeText = 
    		  "***********************************\n"
    		+ "*** Welcome to Lockers Pvt. Ltd *** \n"
    		+ "**********************************";
    private String developerText = 
    		  "*********     Developer   ********\n"
    		+ "            Naraharisetti \n"
    		+ "**********************************";

    private ArrayList<String> options = new ArrayList<>();

    
    public MainMenu() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

    }
    
    public void introWS() {
    	System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("\n");
        Show();
    }
    
    @Override
    public void Show() {
    	System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }

    }

    @Override
    public void GetUserInput() {
        int selectedOption  = 0;
        
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);                
        }  

        if (selectedOption == 3) {
        	System.out.println("Successfully Exited the application");
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.ShowFiles();
                
                this.Show();
                
                break;
                
            case 2: // Show File Options menu
            	FilesMenu fileOptions = new FilesMenu();
            	fileOptions.Show();
            	fileOptions.GetUserInput();
             
                this.Show();
                
                break;
                
            default:
                System.out.println("Invalid Option. Enter 1, 2 or 3.");
                break;
        }        
    }

    public void ShowFiles() {
        System.out.println("List of Files: ");
    	FileHandling fileHandling = new FileHandling(); 
        fileHandling.PrintFiles();    	
    }
       
    public int getOption() {        

        int returnOption = 0;
        
        try {        	
        	returnOption = Integer.parseInt(ApplicationFirstPage.in.nextLine());                                    
        }
        catch (Exception ex) {

        }        
        return returnOption;
    }
}
