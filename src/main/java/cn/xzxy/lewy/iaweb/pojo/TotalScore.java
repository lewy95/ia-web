package cn.xzxy.lewy.iaweb.pojo;

import cn.xzxy.lewy.iaweb.pojo.multiKey.TotalScoreMultiKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_score_total")
@IdClass(TotalScoreMultiKey.class)
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class TotalScore implements Serializable {

    @Id
    @Column(name = "stu_code")
    private String stuCode;

    private int totalScore;

    @Id
    @Column(name = "paper_code")
    private String paperCode;

    @Id
    @Column(name = "create_time")
    private String createTime;

    public String getStuCode() {
        return stuCode;
    }

    public void setStuCode(String stuCode) {
        this.stuCode = stuCode;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
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