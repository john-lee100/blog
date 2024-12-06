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

$(document).ready(function () {
  $('#createDate').datepicker({
    showOn: "both",
    buttonImage: _appContext+"image/yellow/calendar.gif",
    buttonImageOnly: true,
    buttonText: "選擇日期",
    dateFormat: "yymmdd",
    onClose: function () {
      console.log($(this).val());
    }
  });
  
  $('#table1').on('click', 'input[type=button]', function (event) {
    var target = $(event.target);
    var value = target.val();
    if (value === 'add') {
       var new_row = $('#table1 tbody tr:last-child').clone();
       var id = $('#table1 tbody tr:last-child [data-type=cname]').attr('id');
       var index = parseInt(id.substring(id.indexOf('_') + 1)) + 1;
       id = 'name_' + index;
       var input = new_row.find('input[data-type=name]');
       input.attr('id', id);
       input.attr('value', "");
       new_row.find('[data-type]').each(function (index, element) {
         element.value = '';
       });
       $('#table1 tbody').append(new_row);
     }
  });
});

function get(s){
  if(s == undefined) return '';
  return $.trim(s);
}
