package com.uet.billing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderServiceTest {

    @Test
    void calculateTotal_appliesVipDiscount_withoutTouchingDatabase() {
        // Arrange
        DiscountPolicy vip = new VipDiscount();
        OrderService service = new OrderService(vip);

        // Act
        double total = service.calculateTotal(100.0);

        // Assert
        assertEquals(80.0, total, 0.0001);
    }
}