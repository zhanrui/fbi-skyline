package skyline.platform.common.enumeration;

import java.util.Hashtable;

/**
 * ϵͳƽ̨������
 */
public enum ReturnCode implements EnumCode {

    PTOPER_NOT_EXIST("1000", "�û�������"),
    PTOPER_PWD_ERROR("1001", "�û��������");

    private String code = null;
    private String title = null;
    private static Hashtable<String, ReturnCode> aliasEnums;

    ReturnCode(String code, String title) {
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

    public static ReturnCode valueOfAlias(String alias) {
        return aliasEnums.get(alias);
    }

    public String getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }
}
