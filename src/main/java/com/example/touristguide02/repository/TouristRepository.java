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
                "Et bibliotek i Brønshøj",
                List.of (" bibliotek", " Børnevenlig"),
                " Brønshøj"

        ));

        attractions.add(new TouristAttraction(
                "Brønshøj Kirke" ,
                "Et historisk kirke ved Brønshøj Torv",
                List.of (" kirke", " religion"),
                " Brønshøj"

        ));

        attractions.add(new TouristAttraction(
                "Bellahøj Friluftsscene",
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

                attraction.setDescription(
                        updatedAttraction.getDescription()
                );
            }
        }
    }

    public void deleteAttraction(String name) {

        attractions.removeIf(
                attraction ->
                        attraction.getName().equalsIgnoreCase(name)
        );
    }
}




