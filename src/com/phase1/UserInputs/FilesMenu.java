package com.phase1.UserInputs;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import com.phase1.FirstPage.ApplicationFirstPage;
import com.phase1.ManageFiles.FileHandling;

public class FilesMenu implements Screen {
	
	private FileHandling dir = new FileHandling();
	
	private ArrayList<String> options = new ArrayList<>();

    public FilesMenu() {
    	
    	options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");        
    }
    
    @Override
    public void Show() {
    	System.out.println("File Options Menu");
        for (String s : options) {
            System.out.println(s);
        }
    }

    public void GetUserInput() {
        int selectedOption;
       
        MainMenu welcomeScreen = new MainMenu(); 
        
        while ((selectedOption = welcomeScreen.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        
    	switch(option) {

            case 1: // Add File
                this.AddFile();
                
                this.Show();
                break;
            case 2: // Delete File
                this.DeleteFile();
                
                this.Show();
                break;
            case 3: // Search File
                this.SearchFile();
                this.Show();
                break;
                            
            default:
                System.out.println("Invalid Option. Enter 1, 2, 3 or 4.");
                break;                               
        }
    }
        

    public void AddFile() {
        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are adding a file named: " + fileName);
        
		try {
			File file = new File(dir.getName() + fileName);			
			
		      if (file.createNewFile()) {
		    	  System.out.println("File created: " + file.getName());
		    	  dir.filesList().add(file);	
		      } else {
		        System.out.println("This File Already Exits, no need to add another");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}
        
    
    
    public void DeleteFile() {
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are deleting a file named: " + fileName);
        
        
		Path path = FileSystems.getDefault().getPath(FileHandling.name + fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("Deleted File: " + file.getName());
	    	  dir.filesList().remove(file);	
	      } else {
	        System.out.println("Failed to delete file:" + fileName + ", file was not found.");
	      }
    }
    
    public void SearchFile() {
    	
    	Boolean found = false;
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are searching for a file named: " + fileName);
                
        ArrayList<File> files = dir.filesList();
        
                
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("Found " + fileName);
				found = true;
			}
        }
        if (found == false) {
        	System.out.println("File not found");
        }
    }
    
    private String getInputString() {        
    	String outText=ApplicationFirstPage.in.nextLine();
        return (outText);
    }
}
