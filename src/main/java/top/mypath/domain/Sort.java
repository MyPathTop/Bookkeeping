package top.mypath.domain;

import java.io.Serializable;

/**
 * @author 李亚林
 * @date 2019/12/22 21:32
 */
public class Sort implements Serializable {
    private Integer sortId;
    private String sortName;
    private String icon;
    private Integer cancel;

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getCancel() {
        return cancel;
    }

    public void setCancel(Integer cancel) {
        this.cancel = cancel;
    }

}
