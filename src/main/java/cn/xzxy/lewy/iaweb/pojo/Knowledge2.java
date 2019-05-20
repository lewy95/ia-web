package cn.xzxy.lewy.iaweb.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "t_knowledge_info")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Knowledge2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kl_id")
    private int klId;
    @Column(name = "kl_code")
    private String klCode;
    @Column(name = "kl_content")
    private String klContent;
    @Column(name = "kl_level")
    private int klLevel;
    @Column(name = "kl_parentid")
    private int klParentid;
    @Column(name = "kl_comment")
    private String klComment;

    public int getKlId() {
        return klId;
    }

    public void setKlId(int klId) {
        this.klId = klId;
    }

    public String getKlCode() {
        return klCode;
    }

    public void setKlCode(String klCode) {
        this.klCode = klCode;
    }

    public String getKlContent() {
        return klContent;
    }

    public void setKlContent(String klContent) {
        this.klContent = klContent;
    }

    public int getKlLevel() {
        return klLevel;
    }

    public void setKlLevel(int klLevel) {
        this.klLevel = klLevel;
    }

    public int getKlParentid() {
        return klParentid;
    }

    public void setKlParentid(int klParentid) {
        this.klParentid = klParentid;
    }

    public String getKlComment() {
        return klComment;
    }

    public void setKlComment(String klComment) {
        this.klComment = klComment;
    }
}
