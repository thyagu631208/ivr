/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspCServletContext/1.0
 * Generated at: 2019-01-18 07:21:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.json.JSONArray;
import com.genesyslab.studio.backendlogic.BackendLogManager;
import org.apache.log4j.Logger;

public final class dbInputForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/xml;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

Logger logger = BackendLogManager.getLogger("dbInputForm");
request.setCharacterEncoding("UTF-8");

String dbValues = request.getParameter("dbValues");
logger.info("dbValues: " + dbValues);
String strTimeout = request.getParameter( "timeout" );
logger.info("strTimeout: " + strTimeout);
String strAppLanguage = request.getParameter( "app_language" );
logger.info("strAppLanguage: " + strAppLanguage);
String strAppASRLanguage = request.getParameter( "app_asr_language" );
logger.info("strAppASRLanguage: " + strAppASRLanguage);
String strSecurity = request.getParameter( "security" );
logger.info("strSecurity: " + strSecurity);

JSONArray rows = new JSONArray(dbValues);
int numRows = rows.length();
boolean bGenerateDTMFMode = false;

for (int i = 0; i < numRows; i++) { 
	JSONArray row = rows.getJSONArray(i);
	
	int rowLength = row.length();
    for (int j = 0; j < rowLength; j++) {
    	
        String value = row.getString(j);
        try
	    {
	       Integer.parseInt( value );
	       bGenerateDTMFMode = true; // DTMF element present in the data       
	    }
	    catch( Exception e)
	    {
	    	//do nothing
	    }
    }
}


      out.write("\r\n\r\n<vxml version=\"2.1\" xml:lang=\"");
      out.print(strAppLanguage);
      out.write("\" xmlns=\"http://www.w3.org/2001/vxml\" xmlns:gvp=\"http://www.genesyslab.com/2006/vxml21-extension\" \r\n\t\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n\r\n\t<form id=\"DbInputForm\">\r\n\r\n\t\t<field name=\"DbInput\">\r\n\t\t\t");
 if ( strTimeout.length() > 0 ) { 
      out.write("\r\n\t\t\t\t<property name=\"timeout\" value=\"");
      out.print(strTimeout);
      out.write("s\" />\r\n\t\t\t");
}
      out.write("\r\n\t\t\t");
 if ( strSecurity.length() > 0 && strSecurity.equalsIgnoreCase("true")) { 
      out.write("\r\n\t\t\t\t<property name=\"com.genesyslab.private\" value=\"true\" />\r\n\t\t\t");
}
      out.write("\r\n            <grammar xml:lang=\"");
      out.print(strAppASRLanguage);
      out.write("\" root=\"TOPLEVELVOICE\" version=\"1.0\" mode=\"voice\">\r\n\t\t\t\t<rule id=\"TOPLEVELVOICE\" scope=\"public\">\r\n    \t\t\t\t<one-of>\r\n    \t\t\t\t");
 for (int i = 0; i < numRows; i++) { 
                        JSONArray row = rows.getJSONArray(i);
                        int rowLength = row.length();
                        for (int j = 0; j < rowLength; j++) {
                        	String value = row.getString(j);
      out.write("\r\n                        \t<item>");
      out.print(value);
      out.write("</item>");

                        	logger.info("row: " + i +  " value: " + value);
                        }
                        } 
      out.write("\r\n    \t\t\t\t</one-of>\r\n\t\t\t\t</rule>\r\n\t\t\t</grammar>\r\n\t\t\t");
if(bGenerateDTMFMode){
      out.write("\r\n\t\t\t<grammar xml:lang=\"");
      out.print(strAppASRLanguage);
      out.write("\" root=\"TOPLEVELDTMF\" version=\"1.0\" mode=\"dtmf\">\r\n\t\t\t\t<rule id=\"TOPLEVELDTMF\" scope=\"public\">\r\n    \t\t\t\t<one-of>\r\n    \t\t\t\t");
 for (int i = 0; i < numRows; i++) { 
                        JSONArray row = rows.getJSONArray(i);
                        
                        int rowLength = row.length();
                        for (int j = 0; j < rowLength; j++) {
                        	
                        	String value = row.getString(j);
                        	logger.info("row: " + i +  " value: " + value);
                        	try
                        	{
                           		Integer.parseInt( value );
      out.write("\r\n                           \t\t<item>");
      out.print(value);
      out.write("</item>\t   \r\n                        \t");
}
                        	catch( Exception e)
                        	{
                           		// do not add
                        	}
                        }
                     }
      out.write("\r\n    \t\t\t\t</one-of>\r\n\t\t\t\t</rule>\r\n\t\t\t</grammar>\r\n\t\t\t");
}
      out.write("\r\n            <filled>\r\n\t\t\t\t<return namelist=\"DbInput DbInput$\" />\r\n    \t\t</filled>\r\n\t\t\t<noinput><return event=\"noinput\"/></noinput>\r\n\t\t\t<nomatch><return event=\"nomatch\"/></nomatch>\r\n\t\t\t<catch event=\"error.noresource\"><return event=\"error.noresource\"/></catch>\r\n    \t\t<catch event=\"error\"><return event=\"error\"/></catch>\r\n        </field>\r\n    </form>\r\n</vxml>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
