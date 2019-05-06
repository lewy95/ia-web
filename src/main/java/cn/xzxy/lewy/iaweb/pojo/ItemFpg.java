package cn.xzxy.lewy.iaweb.pojo;

import cn.xzxy.lewy.iaweb.pojo.multiKey.ItemFpgMultiKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_item_fpg")
@IdClass(ItemFpgMultiKey.class)
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class ItemFpg implements Serializable {

    @Id
    @Column(name = "pre_order")
    private String preOrder;

    @Id
    @Column(name = "suf_order")
    private String sufOrder;

    private double confidence;

    @Id
    @Column(name = "paper_code")
    private String paperCode;

    @Id
    @Column(name = "create_time")
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

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
