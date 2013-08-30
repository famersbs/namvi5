package com.netand.namvi5.resp;

import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * byte array 를 보내는 함수
 * @author Administrator
 *
 */
public class RespContentByteArray implements RespContent {

	private byte[] content;
	
	public RespContentByteArray( byte[] content ){
		this.content = content;
	}

	@Override
	public boolean writeToResp(BufferedOutputStream out) {
		
		try {
			out.write(content);
		} catch (IOException e) {				
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
}
