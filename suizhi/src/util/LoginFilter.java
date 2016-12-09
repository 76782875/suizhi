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

public class LoginFilter implements Filter {

	private String loginuri;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		loginuri=filterConfig.getInitParameter("loginuri");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq=(HttpServletRequest)request;
		HttpServletResponse httpRes=(HttpServletResponse)response;
		//System.out.println(httpReq.getSession().getServletContext().getRealPath(""));
		String path = httpReq.getContextPath();
		String basePath = httpReq.getScheme()+"://"+httpReq.getServerName()+":"+httpReq.getServerPort()+path+"/";
		String uri=httpReq.getRequestURI();
		HttpSession session=httpReq.getSession();
		System.out.println(session.getAttribute("loginflag"));
		
		//判断是否已经登录
		if(session.getAttribute("loginflag")==null){
				System.out.println("页面请求，用户尚未登录!将重定向到登录页面。");
				httpRes.sendRedirect(basePath+"login.html");
		}else{
			System.out.println("页面请求，用户已经登录!通过。");
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {

	}

}
