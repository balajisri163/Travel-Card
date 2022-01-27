package com.travel.card.repository;


import com.travel.card.model.TravelHistory;
import com.travel.card.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TravelHistoryJDBCRepository implements TravelHistoryRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int saveTravel(TravelHistory travelHistory) {
        return jdbcTemplate.update("INSERT INTO travel_history(\n" +
                        "\tfrom_station, to_station, mode, card_number, fare_charged)\n" +
                        "\tVALUES (?, ?, ?, ?, ?, ?)",
                new Object[] { travelHistory.getFrom_station(),travelHistory.getTo_station(),travelHistory.getMode(),travelHistory.getCard_number(),travelHistory.getFare_charged() });
    }

    @Override
    public int updateTravel(String from_station,String to_station,String mode,String fare_charged,String card_number,Integer travel_id) {
        return jdbcTemplate.update("UPDATE travel_history\n" +
                        "\tSET from_station=?, to_station=?, mode=?, card_number=?, fare_charged=?\n" +
                        "\tWHERE travel_id=?",
                new Object[] { from_station ,to_station,mode,fare_charged,card_number});
    }

    @Override
    public List<TravelHistory> findAll(String cardnumber) {
        try {
            List<TravelHistory> travelHistory = (List<TravelHistory>) jdbcTemplate.queryForObject("SELECT * FROM travel_history WHERE card_number=?",
                    BeanPropertyRowMapper.newInstance(TravelHistory.class), cardnumber);
            return travelHistory;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public TravelHistory findByTravelId(Integer travel_id) {
        try {
            TravelHistory travelHistory =  jdbcTemplate.queryForObject("SELECT * FROM travel_history WHERE travel_id=?",
                    BeanPropertyRowMapper.newInstance(TravelHistory.class), travel_id);
            return travelHistory;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }


}
