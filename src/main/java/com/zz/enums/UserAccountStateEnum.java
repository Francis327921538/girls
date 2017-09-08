package com.zz.enums;

/**
 * Created by zhangz on 2017/9/4.
 */
public enum UserAccountStateEnum {

    LOCKED(-1, "已锁定"),
    IGNORE(0, "忽略"),
    NORMAL(1, "正常");

    private int index;
    private String description;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    UserAccountStateEnum(int index, String description) {
        this.index = index;
        this.description = description;
    }
}
