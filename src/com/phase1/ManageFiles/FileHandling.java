package com.phase1.ManageFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class FileHandling {

   public static final String name = "src/FilesFolder/";
   
    private ArrayList<File> files = new ArrayList<File>();
    
    Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();    
    
    File Dfiles = path.toFile();
       
    public String getName() {
        return name;
    }
    
    public ArrayList<File> filesList() {
    	
        File[] directoryFiles = Dfiles.listFiles();
                        
    	files.clear();
    	if (directoryFiles.length == 0) {
    		System.out.println("There are no file. This folder is empty");
    	}
    	for (int i = 0; i < directoryFiles.length; i++) {
    		if (directoryFiles[i].isFile()) {
    			files.add(directoryFiles[i]);
    		}
    	}
    	
    	Collections.sort(files);
    	
    	return files;
    }
        
    
    public void PrintFiles() {
    	for (File file: filesList())
        {
            System.out.println(file.getName());
        }
    }
    

    
}
