<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="lee" uri="https://extratools"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../home/head.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/buttonSubmit.js"></script>
</head>
<body>
  <div id="main">
    <form id="form1">
      <div class="t3">
        <table>
          <tr>
            <td style="padding-top: 25px;">  
              <b> &raquo; 向${boardSingleInfo.userInfo.userName}留言 </b>
            </td>
          </tr>
        </table>
        <br />
      </div>
      <div class="t" style="margin-bottom: 0px; border-bottom: 80">
        <table class="t10">
          <tr>
            <th class="h"><strong class="fl w"><b>項目:</b>${boardSingleInfo.boardType.typeName}</strong></th>
          </tr>
        </table>
      </div>
      <div class="t t2">
        <table>
          <tr class="tr3">
            <td style="width: 20%" class="r_two">原帖</td>
            <td >
              ${boardSingleInfo.boardsname}
            </td>
          </tr>
          <tr class="tr3">
            <td style="width: 20%" class="r_two">回覆者:${CURRENT_USERID.userName} 
            </td>
            <td >
              <textarea id="message" name="message" cols="70" rows="10" data-name="留言"></textarea><br/><br/>
              <lee:dateTag dateReadOnly="true"/><br/>
            </td>
          </tr>
          <tr class="tr3">
            <td colspan="2" class="tr3">
              <input type="button" id="addReply" value="新增"/>
            </td>
          </tr>
        </table>
      </div>
      <input type='hidden' name='boardId' id='boardId' value='${boardSingleInfo.id}'>
    </form>
  </div>
</body>
</html>