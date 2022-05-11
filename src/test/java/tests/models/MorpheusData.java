package tests.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class MorpheusData {
        @JsonProperty("morpheusdata")
        private Morpheus [] morpheus;
    }
