package com.travel.card.repository;

import com.travel.card.model.TravelHistory;

import java.util.List;

public interface TravelHistoryRepository {
    int saveTravel(TravelHistory travelHistory);

    int updateTravel(String from_station,String to_station,String mode,String fare_charged,String card_number,Integer travel_id);

    List<TravelHistory> findAll(String cardnumber);

    TravelHistory findByTravelId(Integer travel_id);

}
