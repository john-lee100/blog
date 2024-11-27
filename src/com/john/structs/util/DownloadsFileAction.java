package com.john.structs.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.john.util.filestore.FileDownload;

public class DownloadsFileAction extends DispatchAction {

  public ActionForward ruleList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    String documentPath = request.getServletContext().getInitParameter("documentFile");
    String path = request.getServletContext().getRealPath(documentPath);
    File file = new File(path);
    FileDownload.getHttpResponseFile(file, response);
    return null;
  }
}
