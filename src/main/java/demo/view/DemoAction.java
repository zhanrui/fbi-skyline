package demo.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import skyline.platform.common.primefaces.MessageUtil;
import skyline.platform.repository.model.Ptoper;
import skyline.platform.service.PtoperService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.*;

/**
 * demo
 */
@ManagedBean
@ViewScoped
public class DemoAction implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(DemoAction.class);

    private Ptoper selectedRecord;
    private List<Ptoper> detlList;
    private List<Ptoper> filteredDetlList;

    @ManagedProperty(value = "#{ptoperService}")
    private PtoperService ptoperService;

    private String qryDate;

    @PostConstruct
    public void init() {
        try {
            detlList = ptoperService.qryOpers();
        } catch (Exception e) {
            logger.error("初始化时出现错误。", e);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "初始化时出现错误。", "检索数据库出现问题。"));
        }

    }

    public void onQry(ActionEvent actionEvent) {
        detlList = ptoperService.qryOpers();
        MessageUtil.addInfo("查询到数据记录：" + detlList.size());
    }

    //====================================================================================


    public Ptoper getSelectedRecord() {
        return selectedRecord;
    }

    public void setSelectedRecord(Ptoper selectedRecord) {
        this.selectedRecord = selectedRecord;
    }

    public List<Ptoper> getDetlList() {
        return detlList;
    }

    public void setDetlList(List<Ptoper> detlList) {
        this.detlList = detlList;
    }

    public List<Ptoper> getFilteredDetlList() {
        return filteredDetlList;
    }

    public void setFilteredDetlList(List<Ptoper> filteredDetlList) {
        this.filteredDetlList = filteredDetlList;
    }

    public PtoperService getPtoperService() {
        return ptoperService;
    }

    public void setPtoperService(PtoperService ptoperService) {
        this.ptoperService = ptoperService;
    }

    public String getQryDate() {
        return qryDate;
    }

    public void setQryDate(String qryDate) {
        this.qryDate = qryDate;
    }
}
