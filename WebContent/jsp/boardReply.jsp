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
    <div class="t3">
      <form id="form1">
        <table class="t10">
          <tr>
            <td class="tar">
              <input type="hidden" id="boardId" value="${boardSingleInfo.id}"/>
              <a href="#" id='replyPage'> 
                <img src='${pageContext.request.contextPath}/image/yellow/reply.png' />
              </a>
            </td>
          </tr>
        </table>
      </form>
    </div>
    <div class="t">
      <table class="t10">
        <tr>
          <th class="h">
            <strong class="fl w"><b>本頁主題:</b> ${boardSingleInfo.boardsname}</strong>
          </th>
        </tr>
      </table>
    </div>
    <div class="t t2">
      <table>
        <tr class="tr1">
          <th style="width: 20%" rowspan="2" class="r_two"><b>版主：${boardSingleInfo.userInfo.userName}</b>
            <div class="user-pic">
              <table style="border: 0">
                <tr>
                  <td width="1">
                    <a href="" style="cursor: pointer;"> 
                      <img class="pic" src="/blog/image/yellow/rabbit${3}.png" width="100" height="100" border="0" />
                    </a>
                  </td>
                </tr>
              </table>
            </div>
          </th>
          <th class="r_one" valign="top" id="td_4900235" >
            <h1 id="subject_4900235" class="fl">&nbsp;</h1>
            <div class="c"></div>
            <div class="tpc_content">${boardSingleInfo.description}</div>
          </th>
        </tr>
        <tr class="tr1 r_one">
          <th>
            <div class="c"></div>
            <div class="tipad">
              <span class="gray">Posted: |</span> <span><a class="s3">原帖</a> </span>
            </div>
          </th>
        </tr>
      </table>
    </div>
    <c:forEach items="${boardSingleReply}" var="reply">
      <div class="t t2">
        <table>
          <tr class="tr1">
            <th style="width: 20%" rowspan="2" class="r_two"><b>留言者 ${reply.userName}</b>
              <div class="user-pic">
                <table style="border: 0">
                  <tr>
                    <td><a href="" style="cursor: pointer;"> <img class="pic" src="/blog/image/yellow/rabbit${2}.png" width="100" height="100" border="0" />
                    </a></td>
                  </tr>
                </table>
              </div></th>
            <th class="r_one" valign="top">
              <h1 class="fl">&nbsp;</h1>
              <div id="p_4900235" class="c"></div>
              <div class="tpc_content" id="read_4900235">${reply.message}</div>
            </th>
          </tr>
          <tr class="tr1 r_one">
            <th>
              <div id="w_4900235" class="c"></div>
              <div class="tipad">
                <span style="float: right"> <a href="javascript:scroll(0,0)" title="頂端">頂端</a>
                </span> <span class="gray">Posted: |</span> <span><a class="s3">${reply.createDate} </a> </span>
              </div>
            </th>
          </tr>
        </table>
      </div>
    </c:forEach>
    <jsp:include page="page.jsp"/>
  </div>