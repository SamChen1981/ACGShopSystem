package com.acg_shop.entity;

/**
 * 商品
 * Created by mac_zly on 2017/4/24.
 */
public class Good {

    private Integer id;
    private Integer goodId;
    private String goodName;
    private String goodDescription;
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
