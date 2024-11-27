<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script type="text/javascript">
$(document).ready(function() {
  $(document).on('click', '#b1', function() {
    
    var boardId = 2;
    var url = _appContext + 'boardPage.do?method=boardReply&boardId=' + boardId;
    $('#form1').attr('action', url).attr('method', 'post').submit();
    
  });
});

/*function gotoPage() {
  var boardId = 2;
  var url = _appContext + 'boardPage.do?method=boardReply&boardId=' + boardId;
  $('#form1').attr('action', url).attr('method', 'post').submit();
}*/

</script>

<a class="pagetext" id="b1" href="#">下一頁</a>