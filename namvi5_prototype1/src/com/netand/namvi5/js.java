package com.netand.namvi5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netand.namvi5.resp.httpResponUtil;

/**
 * Servlet implementation class js
 */
public class js extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public js() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println( "is js ");
		// URL 파싱
		String[] paths = null;
		String	 module_id = "";
		String	 sub_path = "src";
		paths =  request.getPathInfo().split("/");
		
		if( paths.length < 3){
			// 변수가 충분치 않음
			response.sendError(404, "Argument Error... " );
			return;
		}else{
			module_id = paths[1];
			
			for( int i = 2 ; i < paths.length; ++ i ){
				sub_path += "/" + paths[i];
			}
		}
		
		N5Module module = N5Modules.getInstance().getModule( module_id );	
		System.out.println( request.getPathInfo() + " " + module_id + " " + sub_path);
		
		if( null != module ){
			
			httpResponUtil util = new httpResponUtil();
			util.setAttachment(false);
			util.sendToResp(response, module.getPath(), sub_path );
						
		}else{
			// 등록되지 않은 변수임
			response.sendError(404, "Not Regist Image Error... " );
			return;
		}
	}


}
