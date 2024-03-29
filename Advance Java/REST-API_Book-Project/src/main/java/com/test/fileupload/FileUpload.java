package com.test.fileupload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

@Component
public class FileUpload {
//	single slash are not allowed
//	static path
//	public final String UPLOAD_DIR = "D:\\swapnil.hogade\\Advance Java\\REST-API_Book-Project\\src\\main\\resources\\static";
	public final String UPLOAD_DIR = new ClassPathResource("static/").getFile().getAbsolutePath();

	public FileUpload() throws IOException {

	}

	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f = false;
		try {
//			InputStream is = multipartFile.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
//
////			write
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + "\\" + multipartFile.getOriginalFilename());
//			fos.flush();
//			fos.close();

//			above alternative

			Files.copy(multipartFile.getInputStream(),
					Paths.get(UPLOAD_DIR + "\\" + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
}
