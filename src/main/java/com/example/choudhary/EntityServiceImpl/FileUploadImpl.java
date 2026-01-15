package com.example.choudhary.EntityServiceImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.choudhary.EntityService.FileUpload;
@Service
public class FileUploadImpl implements FileUpload {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		//File Name
				String name = file.getOriginalFilename();
				
				//abc.png
				
				//random name generate file
				
				String randomID=UUID.randomUUID().toString();
				String filename1=randomID.concat(name.substring(name.lastIndexOf(".")));
				
				//Fullpath
				
				String filePath=path+File.separator+filename1;
				
				
				//create folder if not created
				
				File f=new File(path);
				
				if(!f.exists())
				{
					f.mkdir();
				}
				
				//file copy
				
				Files.copy(file.getInputStream(), Paths.get(filePath));
		return filename1;
	}
//
//	@Override
//	public InputStream getResource(String path, String filename) throws FileNotFoundException {
//		// TODO Auto-generated method stub
//		String fullPath=path+File.separator+filename;
//		
//		InputStream is=new FileInputStream(fullPath);
//		
//		//db logic to return inputstream
//		
//		return is;
//	}

	
//	@Override
//	public InputStream getResource(String path, String filename) throws FileNotFoundException {
//	    String fullPath = path + File.separator + filename;
//	    System.err.println("Image Full Path: " + fullPath); // ✅ DEBUG
//	    return new FileInputStream(fullPath);
//	}
	
	@Override
	public InputStream getResource(String path, String filename) throws FileNotFoundException {
	    String fullPath = new File(path + File.separator + filename).getAbsolutePath();
	    System.out.println("Fetching image from: " + fullPath);  // ✅ Debug
	    return new FileInputStream(fullPath);
	}


}
