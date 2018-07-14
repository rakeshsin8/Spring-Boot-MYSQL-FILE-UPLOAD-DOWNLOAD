package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.FileDocument;

@Repository("fileDocumentRepository")
@Transactional
public interface FileDocumentRepository extends JpaRepository<FileDocument, Integer> {

	FileDocument findById(int id);
}
