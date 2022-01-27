package com.travel.card.controller;

import com.travel.card.model.TravelHistory;
import com.travel.card.repository.TravelHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/travel")
public class TravelHistoryController {

    @Autowired
    TravelHistoryRepository travelHistoryRepository;

    @GetMapping("/travel/get")
    public ResponseEntity<List<TravelHistory>> getTravelHistoryByCardNumber(@RequestParam String cardnumber) {

        try {
            List<TravelHistory> travelHistory = new ArrayList<TravelHistory>();

            travelHistoryRepository.findAll(cardnumber).forEach(travelHistory::add);

            if (travelHistory.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(travelHistory, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/travel")
    public ResponseEntity<String> createTravel(@RequestParam String from_station,@RequestParam String to_station,@RequestParam String mode,@RequestParam String fare_charged,@RequestParam String card_number) {
        try {
            TravelHistory travelHistory= new TravelHistory();
            travelHistory.setFrom_station(from_station);
            travelHistory.setTo_station(to_station);
            travelHistory.setCard_number(card_number);
            travelHistory.setMode(mode);
            travelHistory.setFare_charged(fare_charged);

            travelHistoryRepository.saveTravel(travelHistory);
            return new ResponseEntity<>("Travel History was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/travel/update")
    public ResponseEntity<String> updateTravel(@RequestParam Integer travel_id,@RequestParam String from_station,@RequestParam String to_station,@RequestParam String mode,@RequestParam String fare_charged,@RequestParam String card_number) {
        TravelHistory travelHistory = travelHistoryRepository.findByTravelId(travel_id);

        if (travelHistory != null) {
            travelHistoryRepository.updateTravel(from_station,to_station,mode,fare_charged,card_number,travel_id);
            return new ResponseEntity<>("Travel History was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Travel History with travel id =" + travel_id, HttpStatus.NOT_FOUND);
        }
    }


}
