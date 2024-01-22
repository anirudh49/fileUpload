package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Images {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int image_id;
	private String name;
	private String type;
	private byte[] imageData;
	
}
