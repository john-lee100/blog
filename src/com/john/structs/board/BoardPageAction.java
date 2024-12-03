package com.john.structs.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.john.model.bo.BoardInfomation;
import com.john.model.bo.BoardReply;
import com.john.util.Common;
import com.john.web.service.WebContextService;

public class BoardPageAction extends DispatchAction {
  
  /**view版面*/
  public ActionForward initBoardPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.setAttribute("boardAllKindList", BoardPageBo.getBoardType());
    return mapping.findForward("boardList");
  }
  
  /**新增版面*/
  public ActionForward createBoardInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    BoardPageBo.saveBoardInfo(Common.jspParameters(request));
    request.setAttribute(WebContextService.SUCCESS_MESSAGE, "版面建立成功!");
    return mapping.findForward("createType");
  }

  /**view回復區*/
  public ActionForward boardReply(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    int boardId = Common.getInteger(request.getParameter("boardId"));
    String currentPage = request.getParameter("currentPage");
    
    
    BoardInfomation boardSingleInfo = BoardPageBo.getBoardInfomation(boardId);
    
    List<BoardReply> boardSingleReply = BoardPageBo.getBoardReply(boardId , currentPage);
    
    List<Integer> pageStoreList = BoardPageBo.setReplyPageSize(boardId);
    
    BoardPageBo.setReadcount(boardSingleInfo);
    
    request.setAttribute("boardSingleInfo", boardSingleInfo);
    request.setAttribute("boardSingleReply", boardSingleReply);
    request.setAttribute("pageStoreList", pageStoreList);
    
    return mapping.findForward("boardReply");
  }
  
  /** view留言*/
  public ActionForward replyPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    int boardId = Common.getInteger(request.getParameter("boardId"));
    BoardInfomation boardSingleInfo = BoardPageBo.getBoardInfomation(boardId);
    request.setAttribute("boardSingleInfo", boardSingleInfo);
    return mapping.findForward("replyPage");
  }
  
  /** 新增留言*/
  public ActionForward saveReply(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    BoardPageBo.saveReply(Common.jspParameters(request));
    request.setAttribute(WebContextService.SUCCESS_MESSAGE, "留言完成!");
    return replyPage(mapping,form,request,response);
  }
}
