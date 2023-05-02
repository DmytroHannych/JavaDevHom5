package org.example;

import java.math.BigDecimal;

public class ProgectCost {
    private int id;
    private BigDecimal cost;

    public ProgectCost(int id, BigDecimal cost) {
        this.id = id;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ProgectCost" +
                "id=" + id +
                ", cost=" + cost;
    }
}
