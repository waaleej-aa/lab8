package com.uet.billing;

public class Main {
    public static void main(String[] args) {
        OrderService service = new OrderService(new VipDiscount());
        System.out.println("Total: " + service.calculateTotal(100.0));  // prints 80.0
    }
}