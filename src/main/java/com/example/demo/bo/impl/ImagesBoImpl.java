package com.example.demo.bo.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bo.ImagesBo;
import com.example.demo.entities.Images;
import com.example.demo.repositories.ImagesDao;
import com.example.demo.util.ImagesUtil;
@Service
public class ImagesBoImpl implements ImagesBo {

	@Autowired
	ImagesDao imagesDao;
	
	@Override
	public String uploadImage(MultipartFile multipartFile) throws IOException {
		Images images = imagesDao.save(Images.builder()
				.name(multipartFile.getOriginalFilename())
				.type(multipartFile.getContentType())
				.imageData(ImagesUtil.compress(multipartFile.getBytes())).build());
		if(images!=null)
			return "Image uploaded successfully." + images.getName();
		else
		return "Some error occured.";
	}

	@Override
	public Images downloadImages(String imageName) throws IOException {
		Images images =  imagesDao.findByName(imageName);
		images.setImageData(ImagesUtil.decompress(images.getImageData()));
		return images;
	}

}
