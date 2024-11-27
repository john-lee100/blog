$(document).ready(function() {
  $(document).on('click', '#newboard', function() {
    /** 版面*/
    var url = _appContext + 'jsp/createType.jsp';
    $('#form1').attr('action', url).attr('method', 'post').submit();
    
  }).on('click', '#reply', function() {
    /** 單筆瀏覽*/
    let $h3 = $(this).closest('h3');
    let $boardId = $h3.find('input').attr('id');
    var url = _appContext + 'boardPage.do?method=boardReply&boardId=' + $boardId;
    $('#form1').attr('action', url).attr('method', 'post').submit();
    
  }).on('click', '#replyPage', function() {
    /** 回復*/
    var boardId = $('#boardId').val();
    var url = _appContext + 'boardPage.do?method=replyPage&boardId='+boardId;
    $('#form1').attr('action', url).attr('method', 'post').submit();
    
  }).on('click', '#addReply', function() {
    /** 新增回復*/
    if(checkEmpty(['#message']))
      return ;
    var url = _appContext + 'boardPage.do?method=saveReply';
    $('#form1').attr('action', url).attr('method', 'post').submit();
    
  }).on('click', "#addType" , function() {
    /** 新增版面*/
    if(get(_CURRENT_USERID) == ''){
      showMessage('' , '請先登入帳號');
      return ;  
    }
    if(checkEmpty(['#typeID', '#boardsname' ,'#description']))
      return ;
    
    var url = _appContext + '/boardPage.do?method=createBoardInfo';
    $('#form1').attr('action', url).attr('method', 'post').submit();
    
  });
});