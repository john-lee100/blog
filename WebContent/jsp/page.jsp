<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script type="text/javascript">
$(document).ready(function() {
  $(document).on('click', '#next', function() {
    
    var boardId = 2;
    var url = _appContext + 'boardPage.do?method=boardReply&boardId=' + boardId;
    $('#form1').attr('action', url).attr('method', 'post').submit();
    
  });
});

</script>

<a class="pagetext" id="next" href="#">下一頁</a>
<a class="pagetext" id="back" href="#">上一頁</a>