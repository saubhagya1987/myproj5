package com.happyTouristPersistence.enums;



/**
 * @author RAHUL BHALLA
 *
 */
public enum RelationalOperator {
    AND("&&"), OR("||"), GREATER_THAN(">"), LESS_THAN("<"), GREATER_EQUAL(">="), LESSOR_THAN_EQUAL("<="), EQUALS(
            "=="), NOT_EQUALS("!=");
    ;

    private String operator;

    private RelationalOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /*
     * public String toString(){ return operator; }
     */

    public RelationalOperator testName() {
        return RelationalOperator.valueOf(this.operator);
    }
}
