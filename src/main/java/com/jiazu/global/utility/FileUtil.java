/**
 * 文件工具类
 * ============================================================================
 * 声明：北京旺族互联网科技有限公司版权所有
 * ----------------------------------------------------------------------------
 * Official Website: http://www.jiazuww.com
 * ----------------------------------------------------------------------------
 * Copyright: ? 2012 JiaZuWW All Rights Reserved.
 * ----------------------------------------------------------------------------
 * @version: 1.0
 * ----------------------------------------------------------------------------
 * @author: Greatbsky
 * ----------------------------------------------------------------------------
 * @email: verygreat@126.com
 * ----------------------------------------------------------------------------
 * Create at: 2012-8-6 下午3:29:45
 * ============================================================================
 */
package com.jiazu.global.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.jiazu.global.constants.GlobalConstant;
import com.jiazu.global.constants.SysConf;

/**
 * @author GreatHost
 *
 */
public class FileUtil {

	/**
	 * @param file
	 * @return
	 */
	public static String upload(MultipartFile file) {
		String pathname = transfer(file);
		if (StringUtils.isNotEmpty(pathname)) {
			return SysConf.UserImgBasePath + pathname.replace(SysConf.UserImgUploadPath, "");
		} else {
			return "";
		}
	}
	
	/**
	 * @param file
	 * @param i
	 * @param j
	 * @return string[0] 原图
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public static String[] resizeImage(MultipartFile file, int width, int height) {
		int[][] sizes = {{width, height}};
		return resizeImage(file, sizes);
	}

	/**
	 * @param file
	 * @param sizes sizes[i][0]=width,sizes[i][1]=height
	 * @return string[0] 原图
	 */
	public static String[] resizeImage(MultipartFile file, int[][] sizes) {
		String[] strs = new String[sizes.length + 1];
		String pathname = transfer(file);
		if (StringUtils.isNotEmpty(pathname)) {
			strs[0] = SysConf.UserImgBasePath + pathname.replace(SysConf.UserImgUploadPath, "");
			for (int i = 0; i < sizes.length; i++) {
				if (ImgUtil.getImageWidth(pathname) > sizes[i][0] || ImgUtil.getImageHeight(pathname) > sizes[i][1]) {
					String img = ImgUtil.resizeImage(sizes[i][0], sizes[i][1], pathname);
					strs[i + 1] = StringUtils.isEmpty(img) ? null : SysConf.UserImgBasePath + img.replace(SysConf.UserImgUploadPath, "");
				} else {
					strs[i + 1] = strs[0];
				}
			}
			return strs;
		}
		return null;
	}
	
	/**
	 * 保存源文件
	 * @param file
	 * @return 源文件保存路径
	 */
	private static String transfer(MultipartFile file) {
		String oldname = file.getOriginalFilename();
		String pathname = getImgPathName() + oldname.substring(oldname.lastIndexOf(GlobalConstant.DOT)).toLowerCase();
		File dest = new File(pathname);
		while (dest.exists()) {
			pathname = getImgPathName();
			dest = new File(pathname);
		}
		try {
			if (!dest.getParentFile().exists()) {
				dest.mkdirs();
			}
			file.transferTo(dest);
			return pathname;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @return
	 */
	private static String getImgPathName() {
		String today = DateUtil.getToday();
		String filename = DateUtil.Now() + StrUtil.getRandomString(3);
		return String.format("%s/%s/%s", SysConf.UserImgUploadPath, today, filename);
	}

	/**
	 * @param titleimg
	 */
	public static boolean deleteImg(String... files) {
		Logger log = LoggerFactory.getLogger(FileUtil.class);
		boolean valid = true;
		for (String path : files) {
			if (StringUtils.isNotEmpty(path)) {
				File file = new File(SysConf.UserImgDirPath + path);
				if (file.exists()) {
					if (!file.delete()) {
						log.error(String.format(SysConf.format_error_deleteimg, path));
					}
				}
			}
		}
		//删除原图
		if (StringUtils.isNotEmpty(files[0]) && files[0].indexOf("_") > 0) {
			String orginalpath = files[0].substring(0, files[0].indexOf("_"));
			if (files[0].indexOf(".") > 0) {
				orginalpath += files[0].substring(files[0].indexOf("."));
			}
			File fileoriginal = new File(SysConf.UserImgDirPath + orginalpath);
			if (fileoriginal.exists()) {
				if (!fileoriginal.delete()) {
					log.error(String.format(SysConf.format_error_deleteimg, orginalpath));
				}
			}
		}
		return valid;
	}

	/**
	 * @param f
	 * @param width
	 * @param height
	 * @return string[0] 压缩后图 原图不返回
	 */
	public static String[] resizeImage(String siteurl, int width, int height) {
		int[][] sizes = {{width, height}};
		return resizeImage(siteurl, sizes);
	}

	/**
	 * @param file
	 * @param sizes
	 * @return
	 */
	private static String[] resizeImage(String siteurl, int[][] sizes) {
		String path = SysConf.UserImgDirPath + siteurl;
		String[] strs = new String[sizes.length];
		if (StringUtils.isNotEmpty(path)) {
			for (int i = 0; i < sizes.length; i++) {
				if (ImgUtil.getImageWidth(path) > sizes[i][0] || ImgUtil.getImageHeight(path) > sizes[i][1]) {
					String img = ImgUtil.resizeImage(sizes[i][0], sizes[i][1], path);
					strs[i] = StringUtils.isEmpty(img) ? null : SysConf.UserImgBasePath + img.replace(SysConf.UserImgUploadPath, "");
				} else {
					strs[i] = siteurl;
				}
			}
			return strs;
		}
		return null;
	}

	/**
	 * @param path
	 */
	public static void delete(String... files) {
		Logger log = LoggerFactory.getLogger(FileUtil.class);
		for (String path : files) {
			if (StringUtils.isNotEmpty(path)) {
				File file = new File(SysConf.UserImgDirPath + path);
				if (file.exists()) {
					if (!file.delete()) {
						log.error(String.format(SysConf.format_error_deleteimg, path));
					}
				}
			}
		}
	}

	/**
	 * @param string
	 * @return
	 */
	public static String gray(String imgpath) {
		File file = new File(SysConf.UserImgDirPath + imgpath);
		if (file.exists()) {
			String img = ImgUtil.gray(file.getPath());
			return StringUtils.isEmpty(img) ? null : SysConf.UserImgBasePath + img.replace(SysConf.UserImgUploadPath, "");
		}
		return null;
	}

}
