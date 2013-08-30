package com.netand.namvi5;


import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class N5Modules {
	
	// 실글통 ~! 
	private static N5Modules instance = new N5Modules();
	public static N5Modules getInstance(){
		if( null == instance ){
			instance = new N5Modules();
		}
		return instance;
	}
	
	// 모듈 경로 리스트
	private List<String> module_path_list;
	private Map<String, N5Module> modules;
	
	private N5Modules(){
		module_path_list = new LinkedList<String>();
		modules = new TreeMap<String, N5Module>();
	}
	
	public void add( String path ){
		module_path_list.add( path );
	}
	
	/**
	 * 내부에서 실제로 로드 하는 로직
	 */
	public void load(){
		modules.clear();
		
		Iterator<String> module_path_i = module_path_list.iterator();
		
		while( module_path_i.hasNext() ){
			String path = module_path_i.next();
			
			try{
				
				File fp = new File( path );
				
				if( fp.isDirectory() ){
					
					File[] module_dirs = fp.listFiles();
					
					for( int i = 0 ; i < module_dirs.length ; ++ i ){
					
						N5Module cur_md = createN5Module( module_dirs[i] );
						if( null != cur_md ){
							System.out.println("Load Success : " + cur_md );
							modules.put(cur_md.getID() , cur_md );
						}else{
							System.out.println("Load Fail : " + module_dirs[i].getName() );
						}
						
					}
				}
				
			}catch( Exception ex ){
				System.out.println("Error... " + ex );
				ex.printStackTrace();
			}
			
		}
		
	}
	
	/**
	 * 
	 * 특정 경로에서 N5 모듈을 로드 하는 함수
	 * 
	 * @param fp
	 * @return
	 */
	public N5Module createN5Module( File fp ){
		
		// 일단 무조건 로드 ~!!
		String id = fp.getName();
		String path = fp.getAbsolutePath();
		
		return new N5Module( id, path );
		
	}
	
	/**
	 * 모듈  찾기 ( 없으면 null )
	 * @param id
	 * @return
	 */
	public N5Module getModule( String id ){
		return modules.get(id);
	}
	
}
