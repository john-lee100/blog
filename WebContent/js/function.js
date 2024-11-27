/**
 * 共用function
 */
let _appContext = '/blog/';
let _SUCCESS_MESSAGE = $('#SUCCESS_MESSAGE').val();
let _ERROR_MESSAGE = $('#ERROR_MESSAGE').val();
let _CURRENT_USERID = $('#CURRENT_USERID').val();

$(document).ready(function() {
  showMessage('',_SUCCESS_MESSAGE , 'success');
  showMessage('',_ERROR_MESSAGE);
});


/**
 * 提示訊息
 */
function showMessage(title , htmlText , icon){
  if(get(htmlText) !== ''){
    Swal.fire({
      icon :  icon == undefined ?'error':icon,
      title : title,
      html : htmlText
    });  
  }
}

function get(s){
  if(s == undefined) return '';
  return $.trim(s);
}