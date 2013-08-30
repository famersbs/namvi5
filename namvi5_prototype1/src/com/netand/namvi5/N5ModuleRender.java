package com.netand.namvi5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netand.namvi5.resp.httpResponUtil;

public abstract class N5ModuleRender extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected String req_module = "";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public N5ModuleRender() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// URL 파싱
		String[] paths = null; 
		String	 module_id = "";

		// 경로 파싱
		paths =  request.getPathInfo().split("/");		
		if( paths.length < 1){
			// 변수가 충분치 않음
			response.sendError(404, "Argument Error... " );
			return;
		}else{
			module_id = paths[1];
		}
		// 인자 파싱
		req_module = request.getParameter("module");
		
		// 모듈 검색
		N5Module module = N5Modules.getInstance().getModule( module_id );	
		System.out.println( request.getPathInfo() + " " + module_id );
		
		// 해당 모듈을 보낸다
		if( null != module ){
			
			httpResponUtil util = new httpResponUtil();
			util.setContentType("text/html");
			util.setAttachment( false );	// 파일 다운로드아니라는 것을 알린다. 


			// head 만들기
			if( null != getHeader() ) util.addContent( getHeader().getBytes() );
			
			// 모듈 출력
			module.respWrite(util);
			
			// foot 만들기 
			if( null != getFooter() ) util.addContent( getFooter().getBytes() );
			
			// 최종 전송
			util.sendToResp(response);
			
		}else{
			// 등록되지 않은 변수임
			response.sendError(404, "Not Regist Image Error... " );
			return;
		}
	}
	
	
	/**
	 * Http 응답시 상속 받아 구현 하는 쪽에서 리턴할 해더
	 * @return
	 */
	protected abstract String getHeader();
	/**
	 * Http 응답시 상속 받아 구현 하는 쪽에서 리턴할 풋터
	 * @return
	 */
	protected abstract String getFooter();
}
