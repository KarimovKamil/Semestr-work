package ru.itis.inform.models;

public class Goods {
    private int goodsId;
    private String goodsType;
    private int goodsPrice;

    public Goods() {
    }

    public Goods(Builder builder) {
        this.goodsId = builder.goodsId;
        this.goodsType = builder.goodsType;
        this.goodsPrice = builder.goodsPrice;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public static class Builder {
        private int goodsId;
        private String goodsType;
        private int goodsPrice;

        public Builder goodsId(int arg) {
            goodsId = arg;
            return this;
        }

        public Builder goodsType(String arg) {
            goodsType = arg;
            return this;
        }

        public Builder goodsPrice(int arg) {
            goodsPrice = arg;
            return this;
        }

        public Goods build() {
            return new Goods(this);
        }
    }
}
