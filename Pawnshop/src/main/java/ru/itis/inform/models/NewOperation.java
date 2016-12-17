package ru.itis.inform.models;

/**
 * Created by Kamil Karimov on 17.12.2016.
 */
public class NewOperation {
    private int customerId;
    private String goodsType;
    private String goodsDescription;
    private int price;
    private int timeOfReturn;

    public NewOperation(Builder builder) {
        this.customerId = builder.customerId;
        this.goodsType = builder.goodsType;
        this.goodsDescription = builder.goodsDescription;
        this.price = builder.price;
        this.timeOfReturn = builder.timeOfReturn;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public int getPrice() {
        return price;
    }

    public int getTimeOfReturn() {
        return timeOfReturn;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public static class Builder {
        private int customerId;
        private String goodsType;
        private String goodsDescription;
        private int price;
        private int timeOfReturn;

        public Builder customerId(int arg) {
            customerId = arg;
            return this;
        }

        public Builder goodsType(String arg) {
            goodsType = arg;
            return this;
        }

        public Builder goodsDescription(String arg) {
            goodsDescription = arg;
            return this;
        }

        public Builder price(int arg) {
            price = arg;
            return this;
        }

        public Builder timeOfReturn(int arg) {
            timeOfReturn = arg;
            return this;
        }

        public NewOperation build() {
            return new NewOperation(this);
        }
    }
}
