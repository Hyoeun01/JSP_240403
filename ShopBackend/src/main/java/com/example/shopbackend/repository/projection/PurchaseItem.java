package com.example.shopbackend.repository.projection;

import java.time.LocalDateTime;

public interface PurchaseItem {
    String getName();
    Integer getPrice();
    LocalDateTime getPurchaseTime();
}
