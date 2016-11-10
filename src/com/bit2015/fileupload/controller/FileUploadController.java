package com.bit2015.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2015.fileupload.service.FileUploadService;

@Controller
public class FileUploadController {
	@Autowired
	private FileUploadService fileUploadService;

	@RequestMapping("/form")
	public String form() {
		return "form";
	}

	@RequestMapping("/upload")
	public String upload(@RequestParam String email, @RequestParam("file1") MultipartFile file1, Model model) {
		String saveFileName = fileUploadService.restore(file1);

		System.out.println(email);
		System.out.println(saveFileName);
		String url = "/upload-images/" + saveFileName;
		model.addAttribute("urlImage", url);

		return "result";
	}

}
