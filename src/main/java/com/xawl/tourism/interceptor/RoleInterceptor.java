package com.xawl.tourism.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xawl.tourism.utils.JsonUtil;
import net.sf.json.JSONObject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class RoleInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object handle, ModelAndView arg3) throws Exception {

		// TODO Auto-generated method stub
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handle) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");

		if (!(handle instanceof HandlerMethod)) {
			return false;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handle;
		java.lang.reflect.Method method = handlerMethod.getMethod();
		Role role = method.getAnnotation(Role.class);
		if (role != null) {
			int roleCode = role.role();
			if (roleCode == 1) {
				String tokenint = request.getParameter("token");
				Integer token = (Integer) request.getSession().getAttribute("token");

				if (tokenint == null || token == null) {
					send(response, 406, "没有登录，不能进行操作");
					request.getSession().invalidate();
					return false;
				}
				if (String.valueOf(token).equals(tokenint)) {
					return true;
				} else {
					send(response, 407, "token错误，账号可能已在其他终端登录");
					request.getSession().invalidate();
					return false;
				}
			}
		}
		return true;
	}

	public void send(HttpServletResponse response, int status, String message) {
		response.setStatus(HttpStatus.OK.value()); // 设置状态码
		response.setContentType(MediaType.APPLICATION_JSON_VALUE); // 设置ContentType
		response.setCharacterEncoding("UTF-8"); // 避免乱码
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jsonObjec = JsonUtil.createJson(status);
		jsonObjec.element("msg", message);

		try {
			response.getWriter().print(jsonObjec.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
