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
		String foot = "<script> " +
							"var target_URL = \"../module/"+ req_module +"\";" +
							"var target_module = \""+ req_module +"\";" +
					  "</script>" + "</body></html>";
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
							"<title>page case 1</title>\n" +
						    "<!--[if lte IE 8]>\n" +
						      "<script src=\"../lib/angular/json/json2.js\"></script>\n" +
						    "<![endif]-->\n" +    
						    "<!--[if lte IE 8]>\n" +
						      "<script>\n" +
						        "document.createElement('ng-include');\n" +
						        "document.createElement('ng-pluralize');\n" +
						        "document.createElement('ng-view');\n" +						 
						        "// Optionally these for CSS\n" +
						        "document.createElement('ng:include');\n" +
						        "document.createElement('ng:pluralize');\n" +
						        "document.createElement('ng:view');\n" +
						      "</script>\n" +
						    "<![endif]-->\n" +
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
						      "<script src=\"../assets/js/html5shiv.js\"></script>\n" +
						    "<![endif]-->						    \n" +
						  "<script src=\"../lib/jquery/jquery.min.js\"></script>\n" +
						  "<script src=\"../lib/angular/angular.min.js\"></script>\n" +
						  "<script src=\"../lib/bootstrap/js/bootstrap.min.js\"></script>\n" +
						  "<script src=\"../lib/angular/angular-strap.min.js\"></script>\n" +
						  "<script src=\"../lib/nggrid/ng-grid.min.js\"></script>\n" +
						"</head>";
		return head;
	}

}
