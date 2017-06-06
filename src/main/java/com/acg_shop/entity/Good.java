package com.acg_shop.entity;

import javax.persistence.*;

/**
 * 商品
 * Created by mac_zly on 2017/4/24.
 */

@Entity
@Table(name = "goods_table", catalog = "")
public class Good {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "good_id", nullable = false)
    private Integer goodId;

    @Column(name = "good_name", nullable = false)
    private String goodName;

    @Column(name = "good_description", nullable = false)
    private String goodDescription;

    @Column(name = "good_pic", nullable = false)
    private String goodPic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodDescription() {
        return goodDescription;
    }

    public void setGoodDescription(String goodDescription) {
        this.goodDescription = goodDescription;
    }

    public String getGoodPic() {
        return goodPic;
    }

    public void setGoodPic(String goodPic) {
        this.goodPic = goodPic;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", goodDescription='" + goodDescription + '\'' +
                ", goodPic='" + goodPic + '\'' +
                '}';
    }
}
