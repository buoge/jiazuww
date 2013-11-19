/**
 * Freemarker view的处理类,可添加变量
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
 * Create at: 2012-8-11 下午7:17:56
 * ============================================================================
 */
package com.jiazu.core.views;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import com.jiazu.global.constants.SysConstant;

/**
 * @author Architect.bian
 * 
 */
public class FtlView extends FreeMarkerView {

	@Autowired
	SysConstant sysConstant;
	
	@Override
	protected void doRender(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String basePath = request.getContextPath();
		model.put(SysConstant.BASE, basePath);
		model.put(SysConstant.BASECSSKEY, StringUtils.isEmpty(SysConstant.baseCssRootPath) ? basePath : SysConstant.baseCssRootPath);
		model.put(SysConstant.BASEIMGKEY, StringUtils.isEmpty(SysConstant.baseImgRootPath) ? basePath : SysConstant.baseImgRootPath);
		model.put(SysConstant.BASEJSKEY, StringUtils.isEmpty(SysConstant.baseJsRootPath) ? basePath : SysConstant.baseJsRootPath);
		super.doRender(model, request, response);
	}

}
