package com.example.touristguide02.Controller;

import com.example.touristguide02.model.TouristAttraction;
import com.example.touristguide02.Service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;



import java.util.ArrayList;


@Controller

@RequestMapping("/attractions")

public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;

    }

    @GetMapping
    public String getAllAtrractions(Model model){
        model.addAttribute(
                "attractions",
                touristService.getAllAttractions()
        );

        return "attractionList";
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(
            @PathVariable String name) {

        TouristAttraction attraction = touristService.getAttractionByName(name);

        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }


    @PostMapping

    public ResponseEntity<TouristAttraction> addAttraction(
            @RequestBody TouristAttraction attraction) {

        TouristAttraction newAttraction = touristService.addAttraction(attraction);

        return new ResponseEntity<>(newAttraction, HttpStatus.CREATED);
    }

    @PutMapping

    public ResponseEntity<Void> updateAttraction(
            @RequestBody TouristAttraction updatedAttraction) {

        touristService.updateAttraction(updatedAttraction);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{name}")

    public ResponseEntity<Void> deleteAttraction(@PathVariable String name) {
        touristService.deleteAttraction(name);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{name}/tags")

    public String showTags(@PathVariable String name,Model model){

        TouristAttraction attraction = touristService.getAttractionByName(name);

        model.addAttribute("attraction", attraction);

        return "tags";
    }

    @GetMapping("/{name}/edit")

    public String editAttractionForm(@PathVariable  String name, Model model){
        TouristAttraction attraction= touristService.getAttractionByName(name);

        model.addAttribute("attraction", attraction);

        return "updateAttraction";
    }

    @PostMapping("/update")

    public String updateAttractionform(@ModelAttribute TouristAttraction attraction){
        touristService.updateAttraction(attraction);
        return "redirect:/attractions";
    }



    @GetMapping("/add")

    public String showAddAttraction(Model model) {

        model.addAttribute(
                "attraction",
                new TouristAttraction()

        );

        model.addAttribute(
                "cities",
                touristService.getCities()
        );

        model.addAttribute(
                "tags",
                touristService.getTags()
        );

        return "addAttraction";

    }

    @PostMapping("/save")

    public String saveAttraction(
            @ModelAttribute TouristAttraction attraction) {

        touristService.addAttraction(attraction);
        return "redirect:/attractions";

    }







}
