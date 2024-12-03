<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<html>
<style>
ul li {
  list-style-type: none;
  float: left;
  margin-right: 10px;
}

a:-webkit-any-link {
  color: -webkit-link;
  cursor: pointer;
}

a {
  color: #7e7e7e;
  text-decoration: none;
  background-color: transparent;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery3.7.js"></script>
<body>

  <ul>
    <c:forEach items="${pageStoreList}" var="item">
      <li><a href="#" name="pageButton" onclick="pageClc();">${item}</a></li>
    </c:forEach>
  </ul>
  <input type="hidden" id="currentPage" value="${currentPage}" />
  <script>
      var pagenode = document.getElementsByName("pageButton");
      for (var i = 0; i < pagenode.length; i++) {
        (function(i) {
          pagenode[i].onclick = function() {
            var url = _appContext + 'boardPage.do?method=boardReply';
            url += '&boardId=' + $("#boardId").val();
            url += "&currentPage=" + i;
            $('#form1').attr('action', url).attr('method', 'POST').submit();
          }
        })(i)
      };
    </script>
</body>
</html>
