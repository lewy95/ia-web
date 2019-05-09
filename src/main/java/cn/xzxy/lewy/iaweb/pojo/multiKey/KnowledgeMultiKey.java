package cn.xzxy.lewy.iaweb.pojo.multiKey;

import java.io.Serializable;
import java.util.Objects;

public class KnowledgeMultiKey implements Serializable {

    private int itemId;
    private String paperCode;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnowledgeMultiKey that = (KnowledgeMultiKey) o;
        return itemId == that.itemId &&
                Objects.equals(paperCode, that.paperCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, paperCode);
    }
}
