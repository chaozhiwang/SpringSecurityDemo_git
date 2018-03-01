<%@ page contentType="text/html;charset=UTF-8" language="java" %>  
<%   
Exception ex = (Exception) request.getAttribute("Exception");  
String strMsg = "未知错误";  
if(ex!=null)  
    strMsg = ex.getMessage();  
%>  
MyException.jsp
{"ok":"0","msg":"<%=strMsg%>"}  