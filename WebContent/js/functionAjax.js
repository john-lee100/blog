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

var _json;
function ajaxGet(className,methodName,parms){
  
  var data = arrays($('form').serializeArray()); 
  
  if (typeof parms !='undefined'){
    for (var prop in parms) { 
      data[prop] = parms[prop];
    } 
  }
    
  var jsonData = JSON.stringify(data);
  
  $.ajax({type:"POST",
        url:_appContext+'/jsp/util/getJson.jsp?className='+className + '&methodName=' + methodName,
        contentType:"application/json; charset=utf-8",
        dataType:'json',
        cache:false,
        async:false,
        data:jsonData,
        beforeSend:function(){},
        success:function(json){
          _json = json;
        },
        
        error:function(xhr, textStatus, thrownError){
          alert(thrownError);
        },
        complete:function(){}
      });
  
  return _json;
}

function arrays(item){  
  var parms = {};
  for(var i in item){
    if(!item[i].name){
      
    }else{
      if(typeof (parms[item[i].name]) == 'undefined'){
        parms[item[i].name] = item[i].value; 
      }else{
        parms[item[i].name] += "," + item[i].value;
      }
    }
  } 
  return parms; 
}