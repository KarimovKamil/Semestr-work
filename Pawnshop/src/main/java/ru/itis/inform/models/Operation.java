package ru.itis.inform.models;

import java.sql.Date;

public class Operation {
    private int operationId;
    private int goodsId;
    private int customerId;
    private Date pledgeDate;
    private int timeOfReturn;
    private String status;
    private int returnAmount;

    public Operation() {
    }

    public Operation(Builder builder) {
        this.operationId = builder.operationId;
        this.goodsId = builder.goodsId;
        this.customerId = builder.customerId;
        this.pledgeDate = builder.pledgeDate;
        this.timeOfReturn = builder.timeOfReturn;
        this.status = builder.status;
        this.returnAmount = builder.returnAmount;
    }

    public int getOperationId() {
        return operationId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getPledgeDate() {
        return pledgeDate;
    }

    public int getTimeOfReturn() {
        return timeOfReturn;
    }

    public String getStatus() {
        return status;
    }

    public int getReturnAmount() {
        return returnAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Builder {
        private int operationId;
        private int goodsId;
        private int customerId;
        private Date pledgeDate;
        private int timeOfReturn;
        private String status;
        private int returnAmount;

        public Builder operationId(int arg) {
            operationId = arg;
            return this;
        }

        public Builder goodsId(int arg) {
            goodsId = arg;
            return this;
        }

        public Builder customerId(int arg) {
            customerId = arg;
            return this;
        }
        public Builder pledgeDate(Date arg) {
            pledgeDate = arg;
            return this;
        }
        public Builder timeOfReturn(int arg) {
            timeOfReturn = arg;
            return this;
        }
        public Builder status(String arg) {
            status = arg;
            return this;
        }

        public Builder returnAmount(int arg) {
            returnAmount = arg;
            return this;
        }

        public Operation build() {
            return new Operation(this);
        }
    }
}
