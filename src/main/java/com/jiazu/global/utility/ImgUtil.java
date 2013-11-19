/**
 * 图像工具类
 * ============================================================================
 * 声明：北京旺族互联网科技有限公司版权所有
 * ----------------------------------------------------------------------------
 * Official Website: http://www.jiazuww.com
 * ----------------------------------------------------------------------------
 * Copyright: © 2012 JiaZuWW All Rights Reserved.
 * ----------------------------------------------------------------------------
 * @version: 1.0
 * ----------------------------------------------------------------------------
 * @author: Architect.bian
 * ----------------------------------------------------------------------------
 * Create at: 2012-8-5 上午9:57:25
 * ============================================================================
 */
package com.jiazu.global.utility;

import java.io.IOException;

import org.im4java.core.IM4JavaException;
import org.im4java.core.InfoException;

import com.jiazu.core.image.impl.IM4GraphicsMagickEngine;

/**
 * @author Architect.bian
 *
 */
public class ImgUtil {
	
	public static final String southeast = "southeast";

	//	private static ImageEngine engine = new IM4GraphicsMagickEngine();
	private static IM4GraphicsMagickEngine engine = new IM4GraphicsMagickEngine();
	
	public static String resizeImage(int width, int height, String file) {
		try {
			return engine.resizeImages(width, height, file)[0];
		} catch (IOException | InterruptedException | IM4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String[] resizeImages(int width, int height, String... files) {
		try {
			return engine.resizeImages(width, height, files);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String waterTextMark(String text, int size, String color, String gravity, int dissolve, String srcImgPath) {
		try {
			return engine.waterTextMarks(text, size, color, gravity, dissolve, srcImgPath)[0];
		} catch (IOException | InterruptedException | IM4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String waterMark(String waterImgPath, String gravity, int dissolve, String srcImgPath) {
		try {
			return engine.waterMarks(waterImgPath, gravity, dissolve, srcImgPath)[0];
		} catch (IOException | InterruptedException | IM4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String[] waterMarks(String waterImgPath, String gravity, int dissolve, String... srcImgPath) {
		try {
			return engine.waterMarks(waterImgPath, gravity, dissolve, srcImgPath);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String cropImage(int dw, int dh, String srcPaths) {
		try {
			return engine.cropImage(dw, dh, srcPaths)[0];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String[] cropImage(int dw, int dh, String... srcPaths) {
		try {
			return engine.cropImage(dw, dh, srcPaths);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String cutImage(int x, int y, int x2, int y2, String srcPath) {
		try {
			return engine.cutImage(x, y, x2, y2, srcPath)[0];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String rotate(double angle, String srcImgPath) {
		try {
			return engine.rotate(angle, srcImgPath)[0];
		} catch (IOException | InterruptedException | IM4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static String[] rotate(double angle, String... srcImgPath) {
		try {
			return engine.rotate(angle, srcImgPath);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String concatenateImage(int width, int height, String... srcPaths) {
		try {
			return engine.concatenateImage(width, height, srcPaths);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String gray(String srcImgPath) {
		try {
			return engine.gray(srcImgPath)[0];
		} catch (IOException | InterruptedException | IM4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String[] gray(String... srcImgPath) {
		try {
			return engine.gray(srcImgPath);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String showImageInfo(String img) {
		try {
			return engine.showImageInfo(img);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static int getImageWidth(String img) {
		try {
			return engine.getImageWidth(img);
		} catch (InfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int getImageHeight(String img) {
		try {
			return engine.getImageHeight(img);
		} catch (InfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	
	public static String getGeometry(String img) {
		try {
			return engine.getGeometry(img);
		} catch (InfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getImageFormat(String img) {
		try {
			return engine.getImageFormat(img);
		} catch (InfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


}
