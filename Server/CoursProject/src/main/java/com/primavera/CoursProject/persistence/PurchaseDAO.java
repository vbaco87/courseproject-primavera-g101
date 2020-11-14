package com.primavera.CoursProject.persistence;

import com.primavera.CoursProject.application.dto.PurchaseDTO;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.simpleflatmapper.jdbc.spring.ResultSetExtractorImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseDAO implements com.primavera.CoursProject.application.daos.PurchaseDAO {
    private JdbcTemplate jdbcTemplate;

    ResultSetExtractorImpl<PurchaseDTO> purchasesRowMapper =
            JdbcTemplateMapperFactory
                    .newInstance()
                    .addKeys("id")
                    .newResultSetExtractor(PurchaseDTO.class);

    public PurchaseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PurchaseDTO> getAllTransactions(String userId) {
       return null;
    }

    @Override
    public List<PurchaseDTO> getPurchasedTransactions(String userId) {
        final String queryPurchasedTransactions = "SELECT p.id, p.amount, p.price, t.transaction_date FROM purchases p join transactions t on (p.id = t.purchases_id) where user_broker_id = ?";
        return jdbcTemplate.query(queryPurchasedTransactions, purchasesRowMapper, userId);
    }

}
