package skyline.platform.common.primefaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * for <p:messages id="msgs"/>
 */
public class MessageUtil {


    public static void addInfo(String resourceId) {
        addInfo(resourceId, null);
    }

    public static void addInfo(String resourceId, Object[] params) {
        addMessage(resourceId, FacesMessage.SEVERITY_INFO, params);
    }

    public static void addInfoWithClientID(String clientId, String resourceId) {
        addInfoWithClientID(clientId, resourceId, null);
    }

    public static void addInfoWithClientID(String clientId, String resourceId, Object[] params) {
        addMessage(clientId, resourceId, FacesMessage.SEVERITY_INFO, params);
    }

    public static void addWarn(String resourceId) {
        addWarn(resourceId, null);
    }

    public static void addWarn(String resourceId, Object[] params) {
        addMessage(resourceId, FacesMessage.SEVERITY_WARN, params);
    }

    public static void addWarnWithClientID(String clientId, String resourceId) {
        addWarnWithClientID(clientId, resourceId, null);
    }

    public static void addWarnWithClientID(String clientId, String resourceId, Object[] params) {
        addMessage(clientId, resourceId, FacesMessage.SEVERITY_WARN, params);
    }


    public static void addError(String resourceId) {
        addError(resourceId, null);
    }

    public static void addError(String resourceId, Object[] params) {
        addMessage(resourceId, FacesMessage.SEVERITY_ERROR, params);
    }

    public static void addErrorWithClientID(String clientId, String resourceId) {
        addErrorWithClientID(clientId, resourceId, null);
    }

    public static void addErrorWithClientID(String clientId, String resourceId, Object[] params) {
        addMessage(clientId, resourceId, FacesMessage.SEVERITY_ERROR, params);
    }



    public static void addFatal(String resourceId) {
        addFatal(resourceId, null);
    }

    public static void addFatal(String resourceId, Object[] params) {
        addMessage(resourceId, FacesMessage.SEVERITY_FATAL, params);
    }

    public static void addFatalWithClientID(String clientId, String resourceId) {
        addFatalWithClientID(clientId, resourceId, null);
    }

    public static void addFatalWithClientID(String clientId, String resourceId, Object[] params) {
        addMessage(clientId, resourceId, FacesMessage.SEVERITY_FATAL, params);
    }




    private static void addMessage(String resourceId, FacesMessage.Severity severityInfo, Object[] params) {
        addMessage(null, resourceId, severityInfo, params);
    }

    private static void addMessage(String clientId, String resourceId, FacesMessage.Severity severityInfo, Object[] params) {
        if (resourceId == null) {
            throw new NullPointerException("��ϢID δָ����");
        }
        FacesMessage message = Message.getMessage(resourceId, params);
        message.setSeverity(severityInfo);
        FacesContext.getCurrentInstance().addMessage(clientId, message);
    }

}
