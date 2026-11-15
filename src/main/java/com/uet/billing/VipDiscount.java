package com.uet.billing;
public class VipDiscount implements DiscountPolicy {
@Override
public double apply(double amount) {
return amount * 0.80;
}
}