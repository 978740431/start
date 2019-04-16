package com.star.framework;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * @author yuwei
 * @time 2015-10-15上午09:22:06
 */
public abstract class ActionUtil {

	/**
	 * 获得Request对象
	 * @return
	 */
	/*public static HttpServletRequest getRequest() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return sra == null ? null : sra.getRequest();
	}
*/
	/**
	 * 将站点URL存入ServletContext中
	 */
	/*public static void addContextPath(HttpServletRequest request) {
		StringBuffer buf = new StringBuffer("");
		buf.append(request.getScheme()).append("://").append(request.getServerName());

		int port = request.getServerPort();
		if(port != 80) {
			buf.append(":").append(request.getServerPort());
		}
		buf.append(request.getContextPath());

		request.getServletContext().setAttribute(Constant.CONTEXT_PATH_KEY, buf.toString());
	}
*/


}
