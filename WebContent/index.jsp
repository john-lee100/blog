<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="home/head.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<div id="main">
  <div class="t">
    <table>
      <tr>
        <th class="h"><strong class="fl w">用戶資訊</strong></th>
      </tr>
    </table>
  </div>
  <form id="form1">
    <div>
      <table class="table fa">
        <tr class="tr3">
          <td class="td3">帳戶:</td>
          <td>
            <input type="text" id="account" name="account" data-name="帳戶" />
          </td>
        </tr>
        <tr class="tr3">
          <td class="td3">密碼:</td>
          <td>
            <input type="password" id="password" name="password" data-name="密碼"/>
          </td>
        </tr>
        <tr class="tr3">
          <td colspan="2">
            <input type="button" id="login" value="登入" />
          </td>
        </tr>
      </table>
    </div>
  </form>
</div>
</body>
</html>