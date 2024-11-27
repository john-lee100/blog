/**
 * 縣市下拉選單
 */
function getCityOptions(tarObjIds, defaultValue) {
  var url = _appContext + 'options.do?method=getCityOptions';
  var data = {
    tarObjIds : tarObjIds,
    defaultValue : defaultValue
  };
  getAjax(url, data);
}

/**
 * 鄉鎮下拉選單
 */
function getAreaOptions(tarObjIds, defaultValue, parentValue) {
  var url = _appContext + 'options.do?method=getAreaOptions';
  var data = {
    tarObjIds : tarObjIds,
    defaultValue : defaultValue,
    parentValue : parentValue
  };
  getAjax(url, data);
}

/**
 * 版類別下拉選單
 */
function getTypeOptions(tarObjIds, defaultValue) {
  var url = _appContext + 'options.do?method=getTypeOptions';
  var data = {
    tarObjIds : tarObjIds,
    defaultValue : defaultValue
  };
  getAjax(url, data);
}