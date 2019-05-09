package cn.xzxy.lewy.iaweb.pojo.multiKey;

import java.io.Serializable;
import java.util.Objects;

public class PaperIndexMultiKey implements Serializable {

    private String paperCode;
    private String createTime;

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
        PaperIndexMultiKey that = (PaperIndexMultiKey) o;
        return Objects.equals(paperCode, that.paperCode) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperCode, createTime);
    }
}
