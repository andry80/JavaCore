package com.javacore.lesson06;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Order {

    int id;

    LocalDateTime start = LocalDateTime.now();

    LocalDateTime update = LocalDateTime.now();

    OrderStatus status;
    int statusIndex = 0;

    public Order(int id) {
        status = OrderStatus.NEW;
        this.id = id;
    }

    public void setStatus(OrderStatus status) throws InvalidStatusException {
        int num = 0;
        for (int i = 0; status != OrderStatus.values()[i]; i++) {
            num = i + 1;
        }

        if (num <= this.statusIndex) {
            throw new InvalidStatusException("InvalidStatusException");
        } else {
            this.statusIndex = num;
            this.status = status;
            update = LocalDateTime.now();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getId() == order.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public int getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getUpdate() {
        return update;
    }
}
