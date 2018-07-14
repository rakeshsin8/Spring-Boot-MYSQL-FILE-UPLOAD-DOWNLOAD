package com.spring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.model.FileDocument;
import com.spring.service.FileDocumentService;

@RestController
public class FileUploadController {

	@Autowired
	FileDocumentService fileDocumentService;

	@GetMapping("/")
	public ResponseEntity<String> getMsg() {
		return new ResponseEntity<String>("welcome", HttpStatus.OK);
	}

	@PostMapping(path = "/addfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<FileDocument> saveDocument(@RequestParam("image") MultipartFile file) {
		FileDocument fileDocument2 = null;
		try {
			FileDocument fileDocument = new FileDocument();
			fileDocument.setName(file.getOriginalFilename());
			fileDocument.setType(file.getContentType());
			fileDocument.setContent(file.getBytes());
			fileDocument2 = fileDocumentService.saveDocument(fileDocument);
			return new ResponseEntity<FileDocument>(fileDocument2, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<FileDocument>(fileDocument2, HttpStatus.NOT_IMPLEMENTED);
		}

	}

	@GetMapping("/search/{id}")
	public ResponseEntity<FileDocument> getDocument(@PathVariable int id) {
		FileDocument fileDocument = fileDocumentService.findById(id);
		if(fileDocument == null) {
			return new ResponseEntity<FileDocument>(fileDocument, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FileDocument>(fileDocument, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<FileDocument>> getAllDocument() {
		List<FileDocument> fileDocument = fileDocumentService.getAllDocument();
		if(fileDocument == null) {
			return new ResponseEntity<List<FileDocument>>(fileDocument, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FileDocument>>(fileDocument, HttpStatus.OK);
	}
	
}
