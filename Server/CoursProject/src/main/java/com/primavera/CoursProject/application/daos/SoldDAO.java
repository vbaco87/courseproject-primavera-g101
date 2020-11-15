package com.primavera.CoursProject.application.daos;

import com.primavera.CoursProject.application.dto.SoldDTO;

import java.util.List;

public interface SoldDAO {

    public List<SoldDTO> getSoldTransactions(String userId);

    public List<SoldDTO> getAllSoldBitcoins();
}
