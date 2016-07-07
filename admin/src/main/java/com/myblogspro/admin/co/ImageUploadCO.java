package com.myblogspro.admin.co;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Jitendra Singh.
 */
public class ImageUploadCO {

	private MultipartFile upload;
	private String CKEditorFuncNum;

	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}

	public String getCKEditorFuncNum() {
		return CKEditorFuncNum;
	}

	public void setCKEditorFuncNum(String CKEditorFuncNum) {
		this.CKEditorFuncNum = CKEditorFuncNum;
	}
}
