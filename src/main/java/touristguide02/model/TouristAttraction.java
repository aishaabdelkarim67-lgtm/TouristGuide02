package touristguide02.model;

import java.util.List;

public class TouristAttraction {


        private String name;
        private String description;
        private List<String> tags;
        private String city;

        public TouristAttraction (String name, String description, List<String>tags, String city) {
            this.name = name;
            this.description = description;
            this.tags= tags;
            this.city= city;

        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public List <String> getTags(){
            return tags;
        }

        public String getCity(){
            return city;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setTags(List<String> tags){
            this.tags=tags;
        }

        public String toString() {
            return name + "\n" + description;


        }
    }


