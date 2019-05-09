package cn.xzxy.lewy.iaweb.pojo.multiKey;

import java.io.Serializable;
import java.util.Objects;

public class TotalScoreMultiKey implements Serializable {

    private String stuCode;
    private String paperCode;
    private String createTime;

    public String getStuCode() {
        return stuCode;
    }

    public void setStuCode(String stuCode) {
        this.stuCode = stuCode;
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
        TotalScoreMultiKey that = (TotalScoreMultiKey) o;
        return Objects.equals(stuCode, that.stuCode) &&
                Objects.equals(paperCode, that.paperCode) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuCode, paperCode, createTime);
    }
}
