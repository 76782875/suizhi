package util;

/**
 * @author 周志锋
 * @date   new Date();
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

	private String loginuri2;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		loginuri2=filterConfig.getInitParameter("loginuri2");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//判断是否已经登录
		HttpServletRequest httpReq=(HttpServletRequest)request;
		HttpServletResponse httpRes=(HttpServletResponse)response;
		
		System.out.println(httpReq.getSession().getServletContext().getRealPath(""));
		String path = httpReq.getContextPath();
		String basePath = httpReq.getScheme()+"://"+httpReq.getServerName()+":"+httpReq.getServerPort()+path+"/";
		String uri=httpReq.getRequestURI();
		
		HttpSession session=httpReq.getSession();
		System.out.println("登录与否：" + session.getAttribute("loginflag"));

		if(session.getAttribute("loginflag")==null){//未登录
			if(uri.indexOf(loginuri2) > -1){
				chain.doFilter(request, response);
			}else{
				
				System.out.println("请求ajax，但用户未登录");
				
				httpRes.getWriter().write("{\"message\":\"nologin\"}");
				httpRes.getWriter().flush();
				httpRes.getWriter().close();
			}
		}else{//已经登录
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {

	}

}
