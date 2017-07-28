package com.tktick.controller.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.tktick.bean.constant.CommonConstant;
import com.tktick.bean.model.WangModel;
import com.tktick.configure.properties.CustomPropertiesConfig;
import com.tktick.utils.FileUtil;
import com.tktick.utils.StringUtil;

/**
 * 首页控制器
 * @author user
 *
 */
@RestController
@RequestMapping("/common")
public class CommonController extends WebBaseController {
	
	//
	/**
	 * http://blog.csdn.net/kilua_way/article/details/54601195 SpringBoot jar上传文件问题 
	 * @param file 上传的文件
	 * @param from 上传的来源 eg:"editor"
	 * @return
	 */
	@RequestMapping("/upload/{from}.json")
	public Object upload(MultipartFile file, @PathVariable("from") String from){
		//上传文件存放的位置，没使用springboot的默认位置，存放在磁盘的另外一个地方
		String uploadRootPath = CustomPropertiesConfig.getProperty(CommonConstant.UPLOAD_ROOT_PATH);
		InputStream in = null;
		FileOutputStream out = null;
		try {
			in = file.getInputStream();
			File folder = new File(uploadRootPath);
			if(!folder.exists()) folder.mkdirs();
			String savedFileName = StringUtil.uuid(false) + "." + FileUtil.getExtensionName(file.getOriginalFilename());
			FileUtil.writeFile(file, uploadRootPath, savedFileName);
			if(CommonConstant.UPLOAD_FROM_EDITOR.equalsIgnoreCase(from)){
				//返回的地址为 upload/***.jpg
				String returnFilePath = File.separator + uploadRootPath.substring(uploadRootPath.lastIndexOf("/") + 1) + File.separator + savedFileName;
				return new WangModel().setData(new String[]{returnFilePath});
			}else
				return null;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null){
				try {
					in.close();
					if(out != null) out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
