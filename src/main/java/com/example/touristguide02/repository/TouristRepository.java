package com.example.touristguide02.repository;

import com.example.touristguide02.model.TouristAttraction;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository

public class TouristRepository {

    private final ArrayList<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository() {

        attractions.add(new TouristAttraction(
                "Brønshøj Torv",
                "Et torv i Brønshøj",
                List.of ("torv", "Byliv"),
                "Brønshøj"


        ));

        attractions.add(new TouristAttraction(
                "Utterslev Mose",
                "Et naturområde",
                List.of (" natur", "Gratis"),
                "Brønshøj"

        ));

        attractions.add(new TouristAttraction(
                "Brønshøj Bibliotek",
                "Et bibliotek",
                List.of (" bibliotek", " Børnevenlig"),
                " Brønshøj"

        ));

        attractions.add(new TouristAttraction(
                "Brønshøj Kirke" ,
                "En kirke i Brønshøj",
                List.of (" kirke", " religion"),
                " Brønshøj"

        ));

        attractions.add(new TouristAttraction(
                "Friluftsscene",
                "Et udendørs scene",
                List.of (" udendørs", " arrangement"),
                " Brønshøj"
        ));


    }

    public ArrayList<TouristAttraction> getAllAttractions() {
        return attractions;
    }

    public TouristAttraction getAttractionByName(String name) {

        for (TouristAttraction attraction : attractions) {

            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }

        return null;
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);

        return attraction;
    }

    public void updateAttraction(TouristAttraction updatedAttraction) {

        for (TouristAttraction attraction : attractions) {

            if (attraction.getName()
                    .equalsIgnoreCase(updatedAttraction.getName())) {

                attraction.setDescription(updatedAttraction.getDescription());
                        attraction.setCity(updatedAttraction.getCity());
                        attraction.setTags(updatedAttraction.getTags());



            }
        }
    }

    public void deleteAttraction(String name) {

        attractions.removeIf(
                attraction ->
                        attraction.getName().equalsIgnoreCase(name)
        );
    }

    public List<String>getCities(){
        return List.of("Brønshøj");
    }

    public List<String>getTags(){

        return List.of(
                "Torv",
                "Byliv",
                "Natur",
                "Gratis",
                "Bibliotek",
                "Børnevenlig",
                "Kirke",
                "Religion",
                "Udendørs",
                "Arrangement"

        );
    }
}




