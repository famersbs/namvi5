package com.netand.namvi5.resp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 파일 내용을 열어서 보내주는 클래스
 * @author Administrator
 *
 */
public class RespContentFile implements RespContent {

	private String filepath;
	
	public RespContentFile( String FilePath ){
		this.filepath = FilePath;
	}

	@Override
	public boolean writeToResp(BufferedOutputStream out) {
		
		File file = new File( filepath );
		byte b[] = new byte[(int)file.length()];
		
		if (file.isFile())
		{
			try {
				BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
				
				int read = 0;
				
				while ((read = fin.read(b)) != -1){
					out.write(b,0,read);
				}
		

				fin.close();
			} catch (IOException e) {				
				e.printStackTrace();
				return false;
			}
		}else{
			return false;
		}
		
		return true;
	}
	
}
