package com.primavera.CoursProject.persistence;

import com.primavera.CoursProject.application.dto.SoldDTO;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.simpleflatmapper.jdbc.spring.ResultSetExtractorImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SoldDAO implements com.primavera.CoursProject.application.daos.SoldDAO {

    private JdbcTemplate jdbcTemplate;

    ResultSetExtractorImpl<SoldDTO> soldRowMapper =
            JdbcTemplateMapperFactory
                    .newInstance()
                    .addKeys("id")
                    .newResultSetExtractor(SoldDTO.class);

    public SoldDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SoldDTO> getSoldTransactions(String userId) {
        final String querySoldTransactions = "SELECT a.CLOSING_DATE as closingDate , SUM(w.AMOUNT) as amount, SUM(w.PRICE) as price\n" +
                "FROM AUCTIONS a JOIN WINNERS w ON (a.ID = w.AUCTION_ID)\n" +
                "WHERE CREATOR_ID = ? GROUP BY a.CLOSING_DATE;";

        return jdbcTemplate.query(querySoldTransactions, soldRowMapper, userId);
    }

    @Override
    public List<SoldDTO> getAllSoldBitcoins() {
        final String querySoldTransactions = "SELECT a.CLOSING_DATE as closingDate , SUM(w.AMOUNT) as amount, SUM(w.PRICE) as price\n" +
                "FROM AUCTIONS a JOIN WINNERS w ON (a.ID = w.AUCTION_ID)\n" +
                "GROUP BY a.CLOSING_DATE;";

        return jdbcTemplate.query(querySoldTransactions, soldRowMapper);
    }
}
