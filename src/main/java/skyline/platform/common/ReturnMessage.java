package skyline.platform.common;

import java.util.Hashtable;

/**
 * ϵͳƽ̨������
 */
public enum ReturnMessage implements EnumApp {

    PTOPER_NOT_EXIST("1000", "�û�������"),
    PTOPER_PWD_ERROR("1001", "�û��������");

    private String code = null;
    private String title = null;
    private static Hashtable<String, ReturnMessage> aliasEnums;

    ReturnMessage(String code, String title) {
        this.init(code, title);
    }

    @SuppressWarnings("unchecked")
    private void init(String code, String title) {
        this.code = code;
        this.title = title;
        synchronized (this.getClass()) {
            if (aliasEnums == null) {
                aliasEnums = new Hashtable();
            }
        }
        aliasEnums.put(code, this);
        aliasEnums.put(title, this);
    }

    public static ReturnMessage valueOfAlias(String alias) {
        return aliasEnums.get(alias);
    }

    public String getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }
}
