package cn.xzxy.lewy.iaweb.pojo.multiKey;

import java.io.Serializable;
import java.util.Objects;

/**
 * 由于项目需求，单主键无法唯一标识某条记录，而jpa又要求必须要主键，所以解决方法是用符合主键
 * 即由itemId + paperCode + createTime 共同组成的主键
 * 使用符合主键的几点前提：
 * 1.必须实现Serializable序列化
 * 2.必须要有默认的空构造方法
 * 3.重写equals和hashCode方法
 *   EntityManger通过find方法来查找Entity时，是根据equals的返回值来判断的
 */
public class ItemIndexMultiKey implements Serializable {

    private int itemId;
    private String paperCode;
    private String createTime;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String creatTime) {
        this.createTime = creatTime;
    }

    //重点：重写hashcode和equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemIndexMultiKey that = (ItemIndexMultiKey) o;
        return itemId == that.itemId &&
                Objects.equals(paperCode, that.paperCode) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, paperCode, createTime);
    }
}
