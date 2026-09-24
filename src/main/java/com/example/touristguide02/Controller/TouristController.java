package com.example.touristguide02.Controller;

import com.example.touristguide02.model.TouristAttraction;
import com.example.touristguide02.Service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller

@RequestMapping("/attractions")

public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService){
        this.touristService = touristService;

    }

    @GetMapping

    public ResponseEntity<ArrayList<TouristAttraction>>getAllAttractions(){
        ArrayList<TouristAttraction> attractions = touristService.getAllAttractions();
        return new ResponseEntity<>(attractions,HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction>getAttractionByName(
            @PathVariable String name){

        TouristAttraction attraction = touristService.getAttractionByName(name);

        return new ResponseEntity<>(attraction,HttpStatus.OK);
    }


    @PostMapping

    public ResponseEntity<TouristAttraction> addAttraction(
            @RequestBody TouristAttraction attraction){

        TouristAttraction newAttraction = touristService.addAttraction(attraction);

        return new ResponseEntity<>(newAttraction,HttpStatus.CREATED);
    }

    @PutMapping

    public ResponseEntity<Void>updateAttraction(
            @RequestBody TouristAttraction updatedAttraction){

        touristService.updateAttraction(updatedAttraction);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{name}")

    public ResponseEntity<Void> deleteAttraction(@PathVariable String name){
        touristService.deleteAttraction(name);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{name}/edit")

    public String editattractionForm(@PathVariable  String name, Model model){
        TouristAttraction attarction= touristService.getAttractionByName(name);
        return "editAttraction";
    }

    @PostMapping("/update")

    public String updateAttractionform(@ModelAttribute TouristAttraction attraction){
        touristService.updateAttraction(attraction);
        return "redirect:/attractions";
    }



}
