package cn.xzxy.lewy.iaweb.pojo.multiKey;

import java.io.Serializable;
import java.util.Objects;

public class ItemFpgMultiKey implements Serializable {

    private String preOrder;
    private String sufOrder;
    private String paperCode;
    private String createTime;

    public String getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(String preOrder) {
        this.preOrder = preOrder;
    }

    public String getSufOrder() {
        return sufOrder;
    }

    public void setSufOrder(String sufOrder) {
        this.sufOrder = sufOrder;
    }

    public String getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemFpgMultiKey that = (ItemFpgMultiKey) o;
        return Objects.equals(preOrder, that.preOrder) &&
                Objects.equals(sufOrder, that.sufOrder) &&
                Objects.equals(paperCode, that.paperCode) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preOrder, sufOrder, paperCode, createTime);
    }
}
