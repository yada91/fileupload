package com.bit2015.fileupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	public String restore(MultipartFile file) {
		String url = "";

		if (file.isEmpty() == true) {
			return url;
		}

		String originalFileName = file.getOriginalFilename();
		String contentType = file.getContentType();
		Long size = file.getSize();

		url = originalFileName + "//" + contentType + "//" + size;

		return url;
	}

}
