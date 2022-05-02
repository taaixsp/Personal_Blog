package com.generation.blogpessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Theme;
import com.generation.blogpessoal.repository.ThemeRepository;

@RestController
@RequestMapping ("/theme")

public class ThemeController {
	
	@Autowired
	private ThemeRepository themeRepository;
	
	@GetMapping
	public ResponseEntity <List <Theme>> getAll(){
		return ResponseEntity.ok(themeRepository.findAll());
	}

	@GetMapping ("/{id}")
	public ResponseEntity<Theme> getById(@PathVariable Long id){
		return themeRepository.findById(id)
				.map(Response->ResponseEntity.ok(Response))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/description/{description}")
	public ResponseEntity<List <Theme>> getByDescription(@PathVariable String description){
		return ResponseEntity.ok(themeRepository.findAllByDescriptionContainingIgnoreCase(description));
	}
	
	@PostMapping
	public ResponseEntity<Theme> postTheme(@Valid @RequestBody Theme theme){
		return ResponseEntity.status(HttpStatus.CREATED).body(themeRepository.save(theme));
	}
	
	@PutMapping
	public ResponseEntity<Theme> putTheme(@Valid @RequestBody Theme theme){
		return themeRepository.findById(theme.getId())
				.map(Response->ResponseEntity.ok(Response))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> deleteTheme(@PathVariable Long id){
		return themeRepository.findById(id)
				.map(Response->{themeRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();})
				.orElse(ResponseEntity.notFound().build());
	}
}
