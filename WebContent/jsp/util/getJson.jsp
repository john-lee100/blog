<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="com.john.util.Common,java.lang.reflect.Method"%>
<%
String className = request.getParameter("className");
String methodName = request.getParameter("methodName");
 if(!"".equals(className) && !"".equals(methodName)){
  String txt = "";
  try{
    Class c = Class.forName(className);
    Method genFile = c.getMethod(methodName, new Class[]{Object[].class});
    txt = Common.get(genFile.invoke(c.newInstance(), new Object[]{new Object[]{Common.getJsonObj(request)}})); 
  }catch(Exception e){
    e.printStackTrace();
  }
  out.write(!"".equals(txt)?txt:""); 
}else{
  throw new Exception("is empty!!");
} 
%>