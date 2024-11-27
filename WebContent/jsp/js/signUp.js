$(document).ready(function() {
  initStatus();
  
  $(document).on('change', '#city', function() {
    getAreaOptions('#area', '', $(this).val());
    
  }).on('click', '.btn-add-city-list', function() {
    let $td = $(this).closest('td');
    let $ul = $td.find('.ul-multi-city-list');
    let $select = $td.find('.select-city-list-options');
    let optionsValue = $select.val();
    let optionsText = $select.find('option:selected').text();
    let $li = $(getListItem(optionsValue, optionsText));
    $li.appendTo($ul);

  }).on('click', '.btn-remove-list-item', function() {
    let $li = $(this).closest(`li`);
    $li.remove();
  });
});

function initStatus(){
  getCityOptions('#city', '');
}

function getListItem(val, txt) {
  let ele = ``;
  ele += `<li>`;
  ele += `${txt}`;
  ele += `<button type="button" class="btn-remove-list-item">×</button>`;
  ele += `</li>`;
  return ele;
}