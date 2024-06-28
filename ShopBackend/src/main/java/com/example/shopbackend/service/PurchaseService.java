package com.example.shopbackend.service;

import com.example.shopbackend.model.Purchase;
import com.example.shopbackend.repository.projection.PurchaseItem;

import java.util.List;

public interface PurchaseService {
    Purchase savePurchase(Purchase purchase);

    List<PurchaseItem> findPurchaseItemsOfUser(String username);
}
