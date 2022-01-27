package com.travel.card.repository;


import com.travel.card.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WalletJDBCRepository implements WalletRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Wallet wallet) {
        return jdbcTemplate.update("INSERT INTO wallet (cardnumber, amount) VALUES(?,?)",
                new Object[] { wallet.getCardnumber(), wallet.getAmount() });
    }

    @Override
    public int update(String amount,String cardnumber) {
        return jdbcTemplate.update("UPDATE wallet SET amount=? WHERE cardnumber=?",
                new Object[] { amount ,cardnumber});
    }

    @Override
    public Wallet findById(String cardnumber) {
        try {
            Wallet wallet = jdbcTemplate.queryForObject("SELECT * FROM wallet WHERE cardnumber=?",
                    BeanPropertyRowMapper.newInstance(Wallet.class), cardnumber);
            return wallet;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
