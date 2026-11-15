package com.uet.billing;
import java.util.Objects;
// 1. The Strategy Interface (Open for Extension)
public interface DiscountPolicy {
double apply(double amount);
}