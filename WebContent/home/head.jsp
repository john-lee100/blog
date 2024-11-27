<%@page import="com.john.model.bo.UserInfo"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="com.john.web.online.CurrentUser"%>
<%@page import="com.john.web.service.WebContextService"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
pageContext.getRequest().setAttribute(WebContextService.LOGIN_COUNT, CurrentUser.getInstance().size());
%>
<input type="hidden" id="SUCCESS_MESSAGE" value="${SUCCESS_MESSAGE}">
<input type="hidden" id="ERROR_MESSAGE" value="${ERROR_MESSAGE}">
<input type="hidden" id="CURRENT_USERID" value="${CURRENT_USERID}">


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bg.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert2.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery3.7.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/functionAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/functionOption.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/functionValidate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sweetalert2.min.js"></script>
<div id="header">
  <div class="toptool tar">
    <span>
      <a href='${pageContext.request.contextPath}/boardPage.do?method=initBoardPage'>首頁</a> | 
      <a href='${pageContext.request.contextPath}/downloads.do?method=ruleList'>手冊下載</a> | 
      <c:choose>
        <c:when test="${empty CURRENT_USERID}">
          <a href="${pageContext.request.contextPath}/jsp/signUp.jsp">註冊</a>
        </c:when>
        <c:otherwise>
          <a href='${pageContext.request.contextPath}/userPage.do?method=logout'>登出</a>
        </c:otherwise>
      </c:choose>
    </span>
  </div>
  <table>
    <tr>
      <td align="center" height="1" colspan="2"></td>
    </tr>
  </table>
  <div class="guide">
    <span class="s3">&raquo;</span>
    <c:choose>
    <c:when test="${empty CURRENT_USERID}">
      <a href="#">尚未登入</a>
    </c:when>
    <c:otherwise>
      <a href="#">${CURRENT_USERID.userName}</a>
    </c:otherwise>
    </c:choose>
    <span class="r1">目前登入人數:${LOGIN_COUNT}</span>
  </div>
</div>