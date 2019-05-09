package cn.xzxy.lewy.iaweb.pojo;

import cn.xzxy.lewy.iaweb.pojo.multiKey.KnowledgeMultiKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "temp_ik_group")
@IdClass(KnowledgeMultiKey.class)
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Knowledge implements Serializable {

    @Id
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "kl_content")
    private String klContent;

    @Id
    @Column(name = "paper_code")
    private String paperCode;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getKlContent() {
        return klContent;
    }

    public void setKlContent(String klContent) {
        this.klContent = klContent;
    }

    public String getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }
}
