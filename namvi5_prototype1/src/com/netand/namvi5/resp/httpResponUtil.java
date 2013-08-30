package com.netand.namvi5.resp;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;


public class httpResponUtil {
	
	// 최초 한번만 생성 되는 변수
	private static Map<String, String> content_type_map = new TreeMap<String, String>();	
	static {
		// image
        content_type_map.put(".jpg", "image/jpg");
        content_type_map.put(".png", "image/png");
        content_type_map.put(".gif", "image/gif");
        
        // html
        content_type_map.put(".html", "text/html");
        content_type_map.put(".htm", "text/html");
	}

	private boolean attachment = false;
	private String content_type = "";
	
	private List<RespContent> contents = new LinkedList<RespContent>();
	
	/**
	 * 외부에서 조합 하기 위함
	 * @param type
	 */
	public void setContentType( String type ){
		this.content_type = type;
	}
	
	public void setAttachment( boolean enable ){
		attachment = enable;
	}
	
	/**
	 * 컨텐트 추가 ( 바이트 배열  )
	 * @param buff
	 */
	public void addContent( byte[] buff ){
		contents.add( new RespContentByteArray( buff ) );
	}
	
	/**
	 * 파일 추가
	 * @param filepath
	 */
	public void addContentFile( String filepath ){
		contents.add( new RespContentFile( filepath ) );
	}
	
	
	/**
	 * 외부에서 실제 전송 하라고 요청 하는 함수
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public boolean sendToResp( HttpServletResponse response ) throws IOException{
		response.setHeader("Content-Type", content_type); //다운로드할 파일 형식 결정.
		return sendToRest_Content(response);
	}
	
	/**
	 * 컨텐츠 부분을 전송 하는 함수
	 * @return
	 */
	private boolean sendToRest_Content(HttpServletResponse response) throws IOException{
		boolean result = true;
		
		// content 보내기
		BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
		
		Iterator<RespContent> i = contents.iterator();
		while( i.hasNext() ){
			result = i.next().writeToResp( outs );
			if( !result ){
				break;
			}
		}
		
		outs.close();
		return result;
	}	
	
	/**
	 * 파일 하나를 읽어서 바로 보내는 함수 
	 * @param response
	 * @param filepath
	 * @param filename
	 * @throws IOException
	 */
	public void sendToResp( HttpServletResponse response, String filepath, String filename  ) throws IOException{
		
    	// 확장자 별 contenttype 설정
    	int extention_idx = filename.lastIndexOf(".");
    	String content_type = content_type_map.get( filename.substring( extention_idx) );
    	if( null == content_type ) content_type = "text";
    	
		response.setHeader("Content-Type",content_type); //다운로드할 파일 형식 결정.

		if( attachment ){
			response.setHeader("Content-Disposition", "attachment;filename=" + filename + ";");	// 파일명만 추출 해야 할까?
		}
		
		// 컨텐츠 객체 추가
		addContentFile( filepath + "/" + filename );
		
		sendToRest_Content( response );

	}
}
