function getAjax(url, data) {
  $.ajax({
    async : false,
    url : url,
    type : 'POST',
    data : data,
    success : function(response) {
      var script = document.createElement("script");
      script.type = "text/javascript";
      script.text = response;
      document.body.appendChild(script);
      document.body.removeChild(script);
    },
    error : function(xhr, ajaxOptions, thrownError) {
      consoloe.log('error', thrownError);
    }
  });
}