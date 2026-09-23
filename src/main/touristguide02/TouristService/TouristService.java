package com.example.touristguide02.TouristService;

import com.example.touristguide02.model.TouristAttraction;
import com.example.touristguide02.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


    @Service
    public class TouristService {

        private final TouristRepository touristRepository;

        public TouristService(TouristRepository touristRepository) {
            this.touristRepository = touristRepository;
        }

        public ArrayList<TouristAttraction> getAllAttractions() {
            return touristRepository.getAllAttractions();
        }

        public TouristAttraction getAttractionByName(String name) {
            return touristRepository.getAttractionByName(name);
        }

        public TouristAttraction addAttraction(TouristAttraction attraction) {
            return touristRepository.addAttraction(attraction);

        }
        public void updateAttraction( TouristAttraction updateAttraction){
            touristRepository.updateAttraction(updateAttraction);

        }
        public void deleteAttraction(String name){
            touristRepository.deleteAttraction(name);
        }
















    }



