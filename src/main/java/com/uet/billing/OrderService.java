/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uet.billing;

import java.util.Objects;

public class OrderService {
private final DiscountPolicy discountPolicy; // Injected via DI
public OrderService(DiscountPolicy discountPolicy) {
// Defensive Programming: Fail Fast
this.discountPolicy = Objects.requireNonNull(discountPolicy, "Discount policy required");
}
public double calculateTotal(double amount) {
if (amount <= 0) {
throw new IllegalArgumentException("Amount must be positive");
}
return discountPolicy.apply(amount);
}
}
