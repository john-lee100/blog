package com.john.structs.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.john.model.bo.BoardInfomation;
import com.john.model.bo.BoardReply;
import com.john.model.bo.BoardType;
import com.john.model.bo.UserInfo;
import com.john.model.service.ServiceDao;
import com.john.persistence.PersistenceService;
import com.john.util.Common;
import com.john.util.DateTime;

public class BoardPageBo {
  
  @SuppressWarnings("unchecked")
  public static List<BoardType> getBoardType() {
    return (List<BoardType>)ServiceDao.getInstance().getBoardTypeDao().list(" from BoardType ");
  }
  
  public static void saveBoardInfo(Map<String , Object> pramaMap) throws Exception{
    BoardType boardType = (BoardType)ServiceDao.getInstance().getBoardTypeDao().get(BoardType.class, Common.getInteger(pramaMap.get("typeID")));
    UserInfo user = ServiceDao.getInstance().getWebContextService().getUserInfo();
    
    BoardInfomation board = new BoardInfomation();
    board.setBoardsname(Common.get(pramaMap.get("boardsname")));
    board.setDescription(Common.get(pramaMap.get("description")));
    board.setBoardType(boardType);
    board.setCreateDate(DateTime.getYYYMMDD());
    board.setCreateTime(DateTime.getHHMMSS());
    board.setUserInfo(user);
    PersistenceService.getInstance().getHibernateTemplate().save(board);
  }
  
  public static BoardInfomation getBoardInfomation(int boardId){
    return ServiceDao.getInstance().getBoardInfomationDao().getBoardInfomation(boardId);
  }
  
  public static void setReadcount(BoardInfomation obj) {
    obj.setReadcount(Common.setReadSize(obj.getReadcount()));
    ServiceDao.getInstance().getCommonAreaDao().update(obj);
  }
  
  public static List<Integer> setReplyPageSize(int boardID) {
    List<Integer> pageStoreList = new ArrayList<Integer>();
    Map<String , Object> param = new HashMap<String , Object>();
    param.put("boardID", boardID);
    
    int rowCount = 
        ServiceDao.getInstance().getBoardInfomationDao().loadCount(" from BoardReply where boardInfomation.id = :boardID",param);
    if(rowCount > 0) {
      int index = 1;
      for(int i = rowCount ; i > 0 ; i-=10) {
        pageStoreList.add(index);
        index++;
        if(i < 0)break;
      }  
    }else {
      pageStoreList.add(1);
    }
    
    return pageStoreList;
  }
  
  @SuppressWarnings("unchecked")
  public static List<BoardReply> getBoardReply(int boardID , String currentPage) {
    int range[] = new int[] {0 , 10};
    if(Common.getInteger(currentPage) > 0) {
      range[1] = range[1] * (Common.getInteger(currentPage) + 1);
      range[0] = range[1] - 9;
      range[1] = 10;
    }
    
    Map<String , Object> param = new HashMap<String , Object>();
    param.put("boardID", boardID);
    
    List<BoardReply> lists = 
        (List<BoardReply>)ServiceDao.getInstance().getBoardInfomationDao()
        .loadParam("from BoardReply where boardInfomation.id=:boardID order by id", range[0], range[1], param);
    
    return lists;
  }
  
  public static void saveReply(Map<String , Object> pramaMap) {
    int boardId = Common.getInteger(pramaMap.get("boardId"));
    String message = Common.get(pramaMap.get("message"));
    BoardInfomation master = getBoardInfomation(boardId);
    master.setReplycoun(Common.setReplySize(master.getReplycoun()));
    ServiceDao.getInstance().getBoardInfomationDao().update(master);
    
    UserInfo userInfo = ServiceDao.getInstance().getWebContextService().getUserInfo();
    BoardReply boardReply = new BoardReply();
    boardReply.setUserID(userInfo.getId());
    boardReply.setUserName(userInfo.getUserName());
    boardReply.setMessage(message);
    boardReply.setCreateDate(DateTime.getYYYMMDD());
    boardReply.setCreateTime(DateTime.getHHMMSS());
    boardReply.setBoardInfomation(master);
    PersistenceService.getInstance().getHibernateTemplate().save(boardReply);
  }
}