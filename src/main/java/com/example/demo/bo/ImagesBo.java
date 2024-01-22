package com.example.demo.bo;

import java.io.IOException;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Images;

public interface ImagesBo {

	String uploadImage(MultipartFile multipartFile) throws IOException;
	Optional<Images> downloadImages(String imageName); 
}
