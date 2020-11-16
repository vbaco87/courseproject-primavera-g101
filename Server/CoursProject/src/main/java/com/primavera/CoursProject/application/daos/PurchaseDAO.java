package com.primavera.CoursProject.application.daos;

import com.primavera.CoursProject.application.dto.PurchaseDTO;
import com.primavera.CoursProject.application.dto.SoldDTO;

import java.util.List;

public interface PurchaseDAO {
    public List<PurchaseDTO> getAllTransactions(String userId);

    public List<PurchaseDTO> getPurchasedTransactions(String userId);

    public List<PurchaseDTO> getAllPurchaseBitcoins();
}
