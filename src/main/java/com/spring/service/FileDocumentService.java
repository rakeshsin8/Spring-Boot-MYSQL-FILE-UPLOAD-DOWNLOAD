package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.FileDocumentRepository;
import com.spring.model.FileDocument;

@Service("fileDocumentService")
public class FileDocumentService {

	@Autowired
	FileDocumentRepository fileDocumentRepository;

	public FileDocument saveDocument(FileDocument document) {
		try {
			FileDocument f = fileDocumentRepository.save(document);
			return f;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<FileDocument> getAllDocument(){
		try {
			List<FileDocument> f = fileDocumentRepository.findAll();
			return f;
		} catch (Exception e) {
			return null;
		}
	}
	
	public FileDocument findById(int id) {
        return fileDocumentRepository.findById(id);
    }
 
}
