package com.netand.namvi5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.netand.namvi5.resp.httpResponUtil;
import com.netand.util.NADXMLObj;

/**
 * 모듈 에 대한 전반적인 처리 
 * 	--> 나중에 동적 로딩 혹은 매번 갱신 옵션들이 들어 가면, 매번 동일하게 로딩 하여 전달 하도록 하는 역할을 수행 한다~!!
 * @author Administrator
 *
 */
public class N5Module{
	
	/**
	 * 
	 */
	private String type = "unknown";
	private String version = "";
	private String default_set = "";
	private String id;
	private String path;
	private Map<String, List<ModuleSet> > sets;
	
	public N5Module( String id, String path ){
		this.id = id;
		this.path = path;
		sets = new TreeMap<String, List<ModuleSet>>();
		
		parseInformation();
	}
	
	public String getID(){
		return id;
	}
	
	public String getPath(){
		return path;
	}
	
	public String toString(){
		
		StringBuffer buff = new StringBuffer();
		buff.append("N5Module("+id+" "+version+") [ " + type + " " + path +"]\n" );
		
		for( String set_id : sets.keySet()  ){
			buff.append("\t" + set_id +"\n");
			for( ModuleSet cur_set : sets.get(set_id) ){
				buff.append("\t\t" + cur_set.name + " : [" + cur_set.type +"]\n");
			}
		}
		
		return buff.toString() ;
	}
	
	
	/**
	 * 정보 파싱
	 */
	private void parseInformation(){

		// 일단 type, template index, controller index ( 종속 관계 설정 까지... )
		try {
			
			NADXMLObj info = NADXMLObj.createObjectFromFile(path + "/config/config.xml");
						
			type 		= info.getChild("type").getContent();
			version 	= info.getChild("version").getContent();
			default_set	= info.getChild("default_set").getContent();
			
				// Sets load
			Iterator<NADXMLObj> i = info.getChild("sets").getChilds("set").iterator();
			while( i.hasNext() ){
				NADXMLObj cur = i.next();
				
				String set_id = cur.getAttribute("id");
				
				Iterator<NADXMLObj> cur_i = cur.getChilds("element").iterator();
				
					// sets 에 추가
				List<ModuleSet> cur_set = new LinkedList<ModuleSet>();
				sets.put( set_id,cur_set );
				
				while( cur_i.hasNext() ){
					NADXMLObj element = cur_i.next();
					ModuleSet e = new ModuleSet();
					e.type = element.getAttribute("type");
					e.name = element.getContent();
					cur_set.add( e );
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch( NullPointerException e ){
			System.out.println("Illigal XML : " + id + " " + path );
		}
	}
	
	/**
	 * 출력 요청
	 * @param util
	 * @return
	 */
	public boolean respWrite(httpResponUtil util){
		
		boolean result = false;
		for( String set_id : sets.keySet()  ){			
			for( ModuleSet cur_set : sets.get(set_id) ){
				result = cur_set.respWrite(util);
				if( !result ) break;
			}
		}
		return result;
		
	}
	
	
	/**
	 * Module Set ~~! --> 실제 모듈을 구성해서 리턴해 주는 클래스
	 * @author Administrator
	 *
	 */
	private class ModuleSet{
		public String type;
		public String name;
		
		public boolean respWrite( httpResponUtil util ){
			if( "src".equals(type) ){
				util.addContent("<script>\n".getBytes() );
				util.addContentFile( getPath() + "/src/" + name + ".js" );
				util.addContent("\n</script>".getBytes() );
			}else if( "template".equals(type) ){
				util.addContentFile( getPath() + "/template/" + name + ".html" );
			}else{
				return false;
			}
			return true;
		}
	}
}