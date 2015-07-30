package skyline.platform.repository.common;

/**
 * Created by admin on 2015-7-27.
 */
public class MenuItem {

    private String menuItemId;
    private String menuItemPId;
    private String menuLevel;
    private String menuItemLabel;
    private String menuItemIsLeaf;
    private String menuItemUrl;
    private String menuItemDescription;
    private String levelidx;
    private String targetmachine;
    private String childcount;

    public String getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(String menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getMenuItemPId() {
        return menuItemPId;
    }

    public void setMenuItemPId(String menuItemPId) {
        this.menuItemPId = menuItemPId;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuItemLabel() {
        return menuItemLabel;
    }

    public void setMenuItemLabel(String menuItemLabel) {
        this.menuItemLabel = menuItemLabel;
    }

    public String getMenuItemIsLeaf() {
        return menuItemIsLeaf;
    }

    public void setMenuItemIsLeaf(String menuItemIsLeaf) {
        this.menuItemIsLeaf = menuItemIsLeaf;
    }

    public String getMenuItemUrl() {
        return menuItemUrl;
    }

    public void setMenuItemUrl(String menuItemUrl) {
        this.menuItemUrl = menuItemUrl;
    }

    public String getMenuItemDescription() {
        return menuItemDescription;
    }

    public void setMenuItemDescription(String menuItemDescription) {
        this.menuItemDescription = menuItemDescription;
    }

    public String getLevelidx() {
        return levelidx;
    }

    public void setLevelidx(String levelidx) {
        this.levelidx = levelidx;
    }

    public String getTargetmachine() {
        return targetmachine;
    }

    public void setTargetmachine(String targetmachine) {
        this.targetmachine = targetmachine;
    }

    public String getChildcount() {
        return childcount;
    }

    public void setChildcount(String childcount) {
        this.childcount = childcount;
    }
}
