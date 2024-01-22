package com.example.demo.bo;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Images;

public interface ImagesBo {

	String uploadImage(MultipartFile multipartFile) throws IOException;
	Images downloadImages(String imageName) throws IOException; 
}
