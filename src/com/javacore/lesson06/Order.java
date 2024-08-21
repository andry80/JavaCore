package com.javacore.lesson06;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {

    private final int id;
    private LocalDateTime startOrderTime;
    private LocalDateTime updateOrderTime;
    private OrderStatus statusOrder;

    private int statusIndex = 0;

    public Order(int id) {
        this.startOrderTime = LocalDateTime.now();
        this.updateOrderTime = LocalDateTime.now();
        this.statusOrder = OrderStatus.NEW;
        this.id = id;
    }

    public void setStatusOrder(OrderStatus statusOrder) throws InvalidStatusException {
        int num = 0;
        for (int i = 0; statusOrder != OrderStatus.values()[i]; i++) {
            num = i + 1;
        }

        if (num < this.statusIndex) {
            throw new InvalidStatusException("InvalidStatusException");
        } else {
            this.statusIndex = num;
            this.statusOrder = statusOrder;
            this.updateOrderTime = LocalDateTime.now();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getId() == order.getId();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nOrder ID: ")
                .append(this.getId())
                .append("\nOrder status: ")
                .append(this.getStatusOrder())
                .append("\nCreating Order time: ")
                .append(this.getStartOrderTime())
                .append("\nUpdating Order time: ")
                .append(this.getUpdateOrderTime())
                .append("\n");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public int getId() {
        return id;
    }

    public OrderStatus getStatusOrder() {
        return this.statusOrder;
    }

    public LocalDateTime getStartOrderTime() {
        return startOrderTime;
    }

    public LocalDateTime getUpdateOrderTime() {
        return updateOrderTime;
    }
}
