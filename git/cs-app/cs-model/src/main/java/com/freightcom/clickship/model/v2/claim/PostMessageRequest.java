package com.freightcom.clickship.model.v2.claim;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostMessageRequest {
	private String content;
    private List<FileData> files;

    @Data
    @EqualsAndHashCode(callSuper = false)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FileData {
        private String file_name;
        private String upload_id;
        private DateData date;

        @Data
        @EqualsAndHashCode(callSuper = false)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DateData {
            private int year;
            private int month;
            private int day;
        }
    }
}