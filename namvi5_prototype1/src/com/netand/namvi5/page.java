package com.netand.namvi5;

import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class asset
 * 
 * 
 * page 정보를 로드
 * 
 * URL 형식
 * 	page/[모듈id]/[pagetype]
 * 
 * 
 */
public class page extends N5ModuleRender {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public page() {
        super();
    }

	/**
	 * foot 조합 
	 * @return
	 */
    @Override
    protected String getFooter() {
		String foot = 
					  //"<script data-main=\"../page/case_page1/index\" src=\"../lib/require/require.js\"></script>\n" +
					  "</body></html>";
		return foot;
	}

	/**
	 * head 조합
	 * @return
	 */
    @Override
    protected String getHeader() {
		String head = "<!doctype html>\n" +
						"<html lang=\"en\" xmlns:ng=\"http://angularjs.org\"  >\n" +
						"<head>\n" +
							"<meta charset=\"utf-8\">\n" +
							"<meta content=\"IE=edge,chrome=1\" http-equiv=\"X-UA-Compatibl\">\n" + 
							"<title>page case 1</title>\n" +
						    "<!--[if lte IE 8]>\n" +
						      "<script src=\"../lib/angular/json/json2.js\"></script>\n" +
						    "<![endif]-->\n" +    
						    "<!--[if lte IE 8]>\n" + 
							"<script type=\"text/javascript\">\n" +
							"var customtags = [\"ng-grid\", \"ng-include\", \"ng-pluralize\", \"ng-view\", \"alert\", \"tabset\", \"tab\"]" +
							".concat([\"ng:grid\", \"ng:include\", \"ng:pluralize\", \"ng:view\"]);// Optionally these for CSS \n" +
							"for(var t=0;t<customtags.length;t++) document.createElement(customtags[t]);</script>\n"+
							"<![endif]-->" + 
						    "<style>\n" +
						      "ng:view {\n" +
						        "display: block;\n" +
						        "border: 1px solid red;\n" +
						      "}\n" +						 
						      "ng-include {\n" +
						        "display: block;\n" +
						        "border: 1px solid blue;\n" +
						      "}\n" +
						    "</style>\n" +
						  "<link rel=\"stylesheet\" href=\"../lib/bootstrap/css/bootstrap.min.css\">\n" +
						  "<link rel=\"stylesheet\" href=\"../lib/bootstrap/css/bootstrap-responsive.min.css\">\n" +
						  "<link rel=\"stylesheet\" href=\"../lib/nggrid/css/ng-grid.min.css\">\n" +
						    "<link href=\"../lib/bootstrap/css/bootstrap-responsive.css\" rel=\"stylesheet\">\n" +
						    "<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->\n" +
						    "<!--[if lt IE 9]>\n" +
						      "<script src=\"../lib/html5shim/html5.js\"></script>\n" +
						    "<![endif]-->\n" +
						  "<script> " +
								"var target_URL = \"../module/"+ req_module +"\";" +
								"var target_module = \""+ req_module +"\";" +
								//"$(document).ready(function() { angular.bootstrap(document)});" + 
						  "</script>" +
						"</head>";
		return head;
	}

}
