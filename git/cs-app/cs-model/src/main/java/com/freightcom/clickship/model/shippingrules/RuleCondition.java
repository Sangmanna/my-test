package com.freightcom.clickship.model.shippingrules;

public enum RuleCondition {
    EQUAL("is equals to") {
        @Override
        public boolean apply(String x1, String x2) {
            return x1.equals(x2);
        }
    },
    IS_NOT_EQUAL("is not equals to") {
        @Override
        public boolean apply(String x1, String x2) {
            return !x1.equals(x2);
        }
    },
    IS_GREATER("is greater than") {
        @Override
        public boolean apply(String x1, String x2) {
            return Double.valueOf(x1) > Double.valueOf(x2);
        }
    },
    IS_LESSER("is lesser than") {
        @Override
        public boolean apply(String x1, String x2) {
            return Double.valueOf(x1) < Double.valueOf(x2);
        }
    },
    IS_GREATER_AND_EQUAL("is greater than and equals to") {
        @Override
        public boolean apply(String x1, String x2) {
            return Double.valueOf(x1) >= Double.valueOf(x2);
        }
    },
    IS_LESSER_AND_EQUAL("is lesser than or equals to") {
        @Override
        public boolean apply(String x1, String x2) {
            return Double.valueOf(x1) <= Double.valueOf(x2);
        }
    }, IS("is") {
        @Override
        public boolean apply(String x1, String x2) {
            return x1.equals(x2);
        }
    },
    IS_NOT("is not") {
        @Override
        public boolean apply(String x1, String x2) {
            return !x1.equals(x2);
        }
    };
    // You'd include other operators too...

    private final String text;

    private RuleCondition(String text) {
        this.text = text;
    }

    public static RuleCondition findByText(String text) {
        for (RuleCondition v : values()) {
            if (v.text.equals(text)) {
                return v;
            }
        }
        return null;
    }

    // Yes, enums *can* have abstract methods. This code compiles...
    public abstract boolean apply(String x1, String x2);

    @Override
    public String toString() {
        return text;
    }
}
