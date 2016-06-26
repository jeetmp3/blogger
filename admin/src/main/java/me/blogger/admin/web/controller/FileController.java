package me.blogger.admin.web.controller;

import me.blogger.admin.co.ImageUploadCO;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Jitendra Singh.
 */
@Controller
@RequestMapping("/file")
public class FileController  {

	@Value("${application.image.upload.path}")
	String path;

	@RequestMapping("/upload")
	public String upload(ImageUploadCO file, Model model) throws IOException {
		File newFile = new File(path, file.getUpload().getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(newFile);
		stream.write(file.getUpload().getBytes());
		stream.close();
		model.addAttribute("file", newFile.getName());
		model.addAttribute("functionNumber", file.getCKEditorFuncNum());
		return "file/upload";
	}

	@RequestMapping("/browse")
	public void browse(String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
		FileInputStream stream = new FileInputStream(new File(path, name));
		IOUtils.copy(stream, response.getOutputStream());
	}
}
