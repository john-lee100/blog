<%@page contentType="text/html;charset=UTF-8"%>
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
      <table class="t10">
        <tr>
          <td class="rs td3">
            <a href="#" id="newboard"> 
              <img src="${pageContext.request.contextPath}/image/yellow/post.png" id="td_post" />
            </a>
          </td>
        </tr>
      </table>
    </div>
    <div class="contentwrap z">
      <c:forEach items="${boardAllKindList}" var="data1" varStatus="st">
        <div class="t">
          <table class="t10" >
            <tr>
              <th class="h" colspan="7">
                <a class="closeicon fr" style="cursor: pointer;" onclick="return IndexDeploy('85', 0)"> 
                  <img id="img_85" src="${pageContext.request.contextPath}/image/yellow/index/cate_fold.gif" />
                </a>
                <h2>&raquo;<a href="#" class="cfont">${data1.typeName}</a></h2>
              </th>
            </tr>
            <tr></tr>
            <tr class="tr2">
              <td width="*" colspan="2" class="tac">論壇</td>
              <td class="tal y-style e" style="width: 15%">點閱</td>
              <td class="tal y-style e" style="width: 15%">留言</td>
              <td class="tal y-style e" style="width: 10%">日期</td>
              <td class="y-style"       style="width: 20%">版主</td>
            </tr>
            <c:forEach items="${data1.boardInfomation}" var="data2" varStatus="seq">
              <tr class="tr3 f_one">
                <td class="icon tac" width="45">
                  <a href="#">
                    <img src="${pageContext.request.contextPath}/image/yellow/2082210335972b.jpg" width="90" height="80"/>
                  </a>
                </td>
                <td>
                  <h3 class="b">
                    <input type="hidden" id="${data2.id}" />
                    <a href="#" id="reply">${data2.boardsname}</a>
                  </h3>
                </td>
                <td class="tal y-style e"><span class="f14">${data2.readcount}</span></td>
                <td class="tal y-style e"><span class="f14">${data2.replycoun}</span></td>
                <td class="tal y-style e"><span class="f14">${data2.createDate}</span></td>
                <td class="y-style"><span class="f14">${data2.userInfo.userName}</span></td>
              </tr>
            </c:forEach>
            <tr>
              <td class="f_one" colspan="6" style="height: 8px"></td>
            </tr>
          </table>
        </div>
      </c:forEach>
    </div>
    </form>
  </div>
</body>
</html>