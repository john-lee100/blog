<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="../home/head.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/signUp.js"></script>
</head>
<body>
  <div id="main">
    <div class="t" style="margin-bottom: 0; border-bottom: 0">
      <table class="t10">
        <tr>
          <th class="h"><strong class="fl ">註冊使用者</strong> &nbsp;</th>
        </tr>
      </table>
    </div>
    <form id="form1">
      <div class="t t2">
        <table class="t10">
          <tr class="tr3">
            <td class="td3">帳號:</td>
            <td><input type="text" id="account" name="account" size="30" data-name="帳號" /></td>
          </tr>
          <tr class="tr3">
            <td>密碼:</td>
            <td><input type="password" id="password" name="password" size="30" data-name="密碼" /></td>
          </tr>
          <tr class="tr3">
            <td>確認密碼:</td>
            <td><input type="password" id="password2" name="password2" size="30" data-name="確認密碼" /></td>
          </tr>
          <tr class="tr3">
            <td>縣市/鄉鎮:</td>
            <td>
              <select id="city" name="city" class="select-city-list-options"></select> 
              <select id="area" name="area"></select>
              <!--
              <input type="button" class="btn-add-city-list" value="新增" />
              <ul class="ul-multi-city-list"></ul>
              -->
            </td>
          </tr>
          <tr class="tr3">
            <td>住址:</td>
            <td><input type="text" id="address" name="address" size="30" /></td>
          </tr>
          <tr class="tr3">
            <td>姓名:</td>
            <td><input type="text" id="userName" name="userName" size="30" data-name="姓名" /></td>
          </tr>
          <tr class="tr3">
            <td>電子郵件:</td>
            <td><input type="email" id="email" name="email" />@gmail.com</td>
          </tr>
          <tr class="tr3">
            <td colspan="2"><input type="button" id="signUp" value="帳戶註冊" /></td>
          </tr>
        </table>
      </div>
    </form>
  </div>
</body>
</html>