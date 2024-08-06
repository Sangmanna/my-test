package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class File {
    private String message_id;
    private Document document;
    

    @Data
    @EqualsAndHashCode(callSuper = false)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Document {
        private String id;
        private String type;
        private String file_name;
        private String url;
        private String uploaded_at;
        private UploadedBy uploaded_by;
        
        @Data
        @EqualsAndHashCode(callSuper = false)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class UploadedBy {
            private String id;
            private String type;
        }
    }
}