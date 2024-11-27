$(document).ready(function() {
  
  /**使用者登入*/
  $('#login').on('click', function() {
    
    if(checkEmpty(['#account','#password'])) 
      return ;
    
    var url = _appContext + 'userPage.do?method=login';
    $('#form1').attr('action', url).attr('method', 'post').submit();
  });
  
  
  /**帳號註冊*/
  $('#signUp').on('click', function() {
    if(checkEmpty(['#account','#password','#password2','#userName'])) 
      return ;
    
    if($('#password').val() != $('#password2').val()){
      showMessage('','密碼與確認密碼不一致');
      return ;
    }

    var regular = /^[a-zA-Z0-9]{6,}$/;
    var accountRegular = checkRegular($('#account').val() , regular);
    if(accountRegular) {
      showMessage('帳號','不符合規則');
      return ;
    }

    regular = /^(?=^.{8,}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&*=()_+])(?!.*[-\/])/;
    var passRegular = checkRegular($('#password').val() , regular);
    if(passRegular) {
      showMessage('密碼','不符合規則');
      return ;
    }

    var url = _appContext + 'userPage.do?method=signUp';
    $('#form1').attr('action', url).attr('method', 'post');
  });
  
});

/**
 * 正規式
 */
function checkRegular(input , regular) {
  var regexp = new RegExp(regular);
  return !regexp.test(get(input)) ? true: false;
}

/**
 * 檢查字串是否為空值
 * 指定 data-name 屬性
 */
function checkEmpty(){
  var msgAttr = '';
  $.each(arguments[0], function(index, value) {
    if($(value).attr('id') == undefined || 
        $(value).data('name') == undefined) 
      msgAttr += '未指定 ' + value + ' 屬性<br>';
  });
  
  if(msgAttr != ''){
    showMessage('',msgAttr);
    return true;
  }
  
  var msgValue = '';
  $.each(arguments[0], function(index, value) {
    if(get($(value).val()) == '') 
      msgValue += $(value).data('name')+'不為空<br>';
  });
  
  if(msgValue != ''){
    showMessage('',msgValue);
    return true;
  }
  
  return false;
}