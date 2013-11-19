/**
 * 重写sitemesh对freemarker的处理类
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
 * Create at: 2012-8-12 上午11:38:05
 * ============================================================================
 */
package com.jiazu.core.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.module.sitemesh.freemarker.FreemarkerDecoratorServlet;

import freemarker.template.Template;
import freemarker.template.TemplateModel;

/**
 * @author Architect.bian
 *
 */
public class SiteMeshFreemarkerServlet extends FreemarkerDecoratorServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 602800774258454089L;

	/**
	 * 可在此处添加内置变量，或者在@see com.jiazu.core.views.FtlView 中添加内置变量
	 */
	@Override
	protected boolean preTemplateProcess(HttpServletRequest request, HttpServletResponse response, Template template,
			TemplateModel templateModel) throws ServletException, IOException {
//		SimpleHash hash = (SimpleHash) templateModel;
		return super.preTemplateProcess(request, response, template, templateModel);
	}

	
}
