package cn.xzxy.lewy.iaweb.pojo;

import cn.xzxy.lewy.iaweb.pojo.multiKey.ItemIndexMultiKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 实体类
 * 1. @IdClass标注用于标注实体所使用主键规则的类；
 * 2. 在实体中同时标注主键的属性，比如这段代码中的itemId,paperCode,createTime
 */
@Entity
@Table(name = "t_item_index")
@IdClass(ItemIndexMultiKey.class)
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class ItemIndex implements Serializable {

    @Id
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "max_score")
    private int maxScore;

    @Column(name = "min_score")
    private int minScore;

    @Column(name = "avg_score")
    private double avgScore;

    @Column(name = "fc_score")
    private double fcScore;

    @Column(name = "bzc_score")
    private double bzcScore;

    private double nandu;

    private double qufendu;

    @Id
    @Column(name = "paper_code")
    private String paperCode;

    @Id
    @Column(name = "create_time")
    private String createTime;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public int getMinScore() {
        return minScore;
    }

    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public double getFcScore() {
        return fcScore;
    }

    public void setFcScore(double fcScore) {
        this.fcScore = fcScore;
    }

    public double getBzcScore() {
        return bzcScore;
    }

    public void setBzcScore(double bzcScore) {
        this.bzcScore = bzcScore;
    }

    public double getNandu() {
        return nandu;
    }

    public void setNandu(double nandu) {
        this.nandu = nandu;
    }

    public double getQufendu() {
        return qufendu;
    }

    public void setQufendu(double qufendu) {
        this.qufendu = qufendu;
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
}
