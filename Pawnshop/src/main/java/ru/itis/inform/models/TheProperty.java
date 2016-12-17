package ru.itis.inform.models;

public class TheProperty extends Goods {
    private int propertyId;
    private String address;
    private int dwellingSpace;

    public TheProperty() {
    }

    public TheProperty(Goods.Builder builder) {
        super(builder);
    }

    public TheProperty(Builder builder) {
        super(builder);
        this.address = builder.address;
        this.dwellingSpace = builder.dwellingSpace;
        this.propertyId = builder.propertyId;
    }

    public String getAddress() {
        return address;
    }

    public int getDwellingSpace() {
        return dwellingSpace;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public static class Builder extends Goods.Builder {
        private int propertyId;
        private String address;
        private int dwellingSpace;

        public Builder propertyId(int arg) {
            propertyId = arg;
            return this;
        }

        public Builder address(String arg) {
            address = arg;
            return this;
        }

        public Builder dwellingSpace(int arg) {
            dwellingSpace = arg;
            return this;
        }

        public TheProperty build() {
            return new TheProperty(this);
        }
    }
}
