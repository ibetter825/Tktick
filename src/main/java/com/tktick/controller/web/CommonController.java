package com.tktick.controller.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.tktick.bean.constant.CommonConstant;
import com.tktick.configure.properties.CustomPropertiesConfig;

/**
 * 首页控制器
 * @author user
 *
 */
@RestController
@RequestMapping("/common")
public class CommonController extends WebBaseController {
	
	//http://blog.csdn.net/kilua_way/article/details/54601195 SpringBoot jar上传文件问题
	@RequestMapping("/upload")
	public String upload(MultipartFile file){
		String root = CustomPropertiesConfig.getProperty(CommonConstant.UPLOAD_ROOT_PATH);
		try {
			InputStream in = file.getInputStream();
			File saveFile = new File(root);
			if(!saveFile.exists()) saveFile.mkdirs();
			FileOutputStream out = new FileOutputStream(new File(root+"/11.jpg"));
			byte[] temp = new byte[1024];
			int i = in.read(temp);
			while (i != -1){
				out.write(temp,0,temp.length);
				out.flush();
				i = in.read(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
