package cn.xzxy.lewy.iaweb.pojo;

import cn.xzxy.lewy.iaweb.pojo.multiKey.PaperIndexMultiKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_paper_index")
@IdClass(PaperIndexMultiKey.class)
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class PaperIndex implements Serializable {

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
    private double xindu;

    @Id
    @Column(name = "paper_code")
    private String paperCode;

    @Id
    @Column(name = "create_time")
    private String createTime;

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

    public double getXindu() {
        return xindu;
    }

    public void setXindu(double xindu) {
        this.xindu = xindu;
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
