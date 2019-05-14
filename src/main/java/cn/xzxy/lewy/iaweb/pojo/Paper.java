package cn.xzxy.lewy.iaweb.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "t_paper_info")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "paper_code")
    private String paperCode;

    @Column(name = "paper_name")
    private String paperName;

    @Column(name = "paper_major")
    private String paperMajor;

    @Column(name = "paper_designer")
    private String paperDesigner;

    @Column(name = "paper_testtime")
    private String paperTesttime;

    @Column(name = "paper_affiliate")
    private String paperAffiliate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pi_id",referencedColumnName = "id")
    private PaperItem paperItem;

    public PaperItem getPaperItem() {
        return paperItem;
    }

    public void setPaperItem(PaperItem paperItem) {
        this.paperItem = paperItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getPaperMajor() {
        return paperMajor;
    }

    public void setPaperMajor(String paperMajor) {
        this.paperMajor = paperMajor;
    }

    public String getPaperDesigner() {
        return paperDesigner;
    }

    public void setPaperDesigner(String paperDesigner) {
        this.paperDesigner = paperDesigner;
    }

    public String getPaperTesttime() {
        return paperTesttime;
    }

    public void setPaperTesttime(String paperTesttime) {
        this.paperTesttime = paperTesttime;
    }

    public String getPaperAffiliate() {
        return paperAffiliate;
    }

    public void setPaperAffiliate(String paperAffiliate) {
        this.paperAffiliate = paperAffiliate;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", paperCode='" + paperCode + '\'' +
                ", paperName='" + paperName + '\'' +
                ", paperMajor='" + paperMajor + '\'' +
                ", paperDesigner='" + paperDesigner + '\'' +
                ", paperTesttime='" + paperTesttime + '\'' +
                ", paperAffiliate='" + paperAffiliate + '\'' +
                '}';
    }
}
