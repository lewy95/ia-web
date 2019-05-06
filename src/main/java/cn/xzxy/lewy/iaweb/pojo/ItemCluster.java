package cn.xzxy.lewy.iaweb.pojo;

import cn.xzxy.lewy.iaweb.pojo.multiKey.ItemClusterMultiKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_item_cluster")
@IdClass(ItemClusterMultiKey.class)
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class ItemCluster implements Serializable {

    @Id
    @Column(name = "stu_code")
    //@Transient
    private String stuCode;

    @Column(name = "good_item")
    private String goodItem;

    @Column(name = "bad_item")
    private String badItem;

    private double centers;

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

    public String getGoodItem() {
        return goodItem;
    }

    public void setGoodItem(String goodItem) {
        this.goodItem = goodItem;
    }

    public String getBadItem() {
        return badItem;
    }

    public void setBadItem(String badItem) {
        this.badItem = badItem;
    }

    public double getCenters() {
        return centers;
    }

    public void setCenters(double centers) {
        this.centers = centers;
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
