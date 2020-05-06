package com.bolsadeideas.springboot.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
public class UploadFileServiceImpl implements IUploadFileService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private final static String UPLOADS_FOLDER = "uploads";


	public String copy(MultipartFile file) throws IOException {
		String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		Path rootPath = getPath(fileName);
		log.info("rootPath: " + rootPath);
		Files.copy(file.getInputStream(), rootPath);
		
		return fileName;
	}


	public boolean delete(String fileName) {
		Path rootPath = getPath(fileName);
		File file = rootPath.toFile();
		
		if (file.exists() && file.canRead()) {
			if(file.delete()) {
				return true;
			}
		}
		
		return false;
	}
	private Path getPath(String fileName) {
		return Paths.get(UPLOADS_FOLDER).resolve(fileName).toAbsolutePath();
	}

	public void deleteAll() {
		FileSystemUtils.deleteRecursively(Paths.get(UPLOADS_FOLDER).toFile());
		
	}

	public void init() throws IOException {
		Files.createDirectories(Paths.get(UPLOADS_FOLDER));
	}
}
