package com.baalam.filtro;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baalam.controller.LoginMB;

@WebFilter("/vistas/*")
public class FiltroAutenticacion implements Filter {

	@Inject LoginMB loginMB;
	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {    

    	HttpServletRequest req = (HttpServletRequest) request;
    	if(isAjaxRequest((HttpServletRequest)request)){
    		if (loginMB != null && loginMB.getUsuario()!=null && loginMB.getUsuario().getIdUsuario()!=null) {
                chain.doFilter(request, response);
            } else {
            	response.setContentType("text/xml");
            	response.getWriter()
            	    .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
            	    .printf("<partial-response><redirect url=\"%s\"></redirect></partial-response>", req.getContextPath() + "/login.xhtml?msg=nosession");
            }
        }
    	else{
            if (loginMB != null && loginMB.getUsuario()!=null && loginMB.getUsuario().getIdUsuario()!=null) {
                // User is logged in, so just continue request.
                chain.doFilter(request, response);
            } else {
                // User is not logged in, so redirect to index.
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(req.getContextPath() + "/login.xhtml?msg=nosession");
            }
    	}
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean isAjaxRequest(HttpServletRequest request) {
		if(request != null && request.getHeader("X-Requested-With")!=null){
	        return "xmlhttprequest".equals(request.getHeader("X-Requested-With").toLowerCase());
		}else{
			return false;
		}
    }

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}