<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="lee" uri="https://extratools" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../home/head.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/buttonSubmit.js"></script>
</head>
<body onload="getTypeOptions('#typeID', '');">
  <div id="main">
    <div class="t" >
      <table class="t10">
        <tr>
          <th class="h"><strong class="fl w">增加版面</strong></th>
        </tr>
      </table>
    </div>
    <form id="form1">
      <div class="t t2">
        <table class="t10" >
          <tr class="tr3">
            <td>類別:</td>
            <td>
              <select id="typeID" name="typeID" data-name="類別"></select>
            </td>
          </tr>
          <tr class="tr3">
            <td>名稱:</td> 
            <td><input type="text" id="boardsname" name="boardsname" data-name="名稱"/ size="30"></td>
          </tr>
          <tr class="tr3">
            <td>描述:</td>
            <td><textarea id="description" name="description" data-name="描述"></textarea></td>
          </tr>
          <tr class="tr3">
            <td>建立日期:</td>
            <td>
              <lee:dateTag dateReadOnly="true"/>
            </td>
          </tr>
          <tr class="tr3">
            <td colspan="2"><input type="button" id="addType" value="新增" /></td>
          </tr>
        </table>
      </div>
    </form>
  </div>
</body>
</html>