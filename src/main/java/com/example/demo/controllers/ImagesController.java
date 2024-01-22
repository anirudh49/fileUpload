package com.example.demo.controllers;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bo.ImagesBo;
import com.example.demo.entities.Images;

@RestController
@RequestMapping("/images")
public class ImagesController {

	@Autowired
	ImagesBo imagesBo;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile multipartFile) throws IOException{
		imagesBo.uploadImage(multipartFile);
		return ResponseEntity.ok("File uploaded Successfully.");
	}
	
	@GetMapping("/download/{imageName}")
	public ResponseEntity<?> downloadImage(@PathVariable("imageName") String name) throws IOException{
		Images result = imagesBo.downloadImages(name);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(result.getImageData());
		
	}
}
