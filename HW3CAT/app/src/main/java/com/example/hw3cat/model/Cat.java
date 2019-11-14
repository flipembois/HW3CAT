package com.example.hw3cat.model;

import java.io.Serializable;
import java.util.List;

public class Cat implements Serializable {

    private Integer index_id;
    private String url;
    private List<BreedsBean> breeds;

    public Integer getIndex_id() {
        return index_id;
    }

    public void setIndex_id(int index_id) {
        this.index_id = index_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<BreedsBean> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<BreedsBean> breeds) {
        this.breeds = breeds;
    }

    public static class BreedsBean implements Serializable {

        private WeightBean weight;
        private String id;
        private String name;
        private String temperament;
        private String origin;
        private String description;
        private String life_span;
        private int dog_friendly;
        private String wikipedia_url;

        public WeightBean getWeight() {
            return weight;
        }

        public void setWeight(WeightBean weight) {
            this.weight = weight;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTemperament() {
            return temperament;
        }

        public void setTemperament(String temperament) {
            this.temperament = temperament;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLife_span() {
            return life_span;
        }

        public void setLife_span(String life_span) {
            this.life_span = life_span;
        }

        public int getDog_friendly() {
            return dog_friendly;
        }

        public void setDog_friendly(int dog_friendly) {
            this.dog_friendly = dog_friendly;
        }

        public String getWikipedia_url() {
            return wikipedia_url;
        }

        public void setWikipedia_url(String wikipedia_url) {
            this.wikipedia_url = wikipedia_url;
        }

        public static class WeightBean implements Serializable {

            private String imperial;
            private String metric;

            public WeightBean() {
            }

            public WeightBean(String imperial) {
                this.imperial = imperial;
            }

            public String getImperial() {
                return imperial;
            }

            public void setImperial(String imperial) {
                this.imperial = imperial;
            }

            public String getMetric() {
                return metric;
            }

            public void setMetric(String metric) {
                this.metric = metric;
            }
        }
    }
}
