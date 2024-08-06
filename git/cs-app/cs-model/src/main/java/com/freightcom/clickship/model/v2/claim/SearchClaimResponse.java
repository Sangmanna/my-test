package com.freightcom.clickship.model.v2.claim;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@SuppressWarnings("unused")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchClaimResponse {
    private String url;
    private Data_ data;

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data_ {
        private Page page;
        private int num_new_admin_messages;
        private boolean mode_and_category_ignored;

        @Data
        @NoArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Page {
            private List<ClaimDTO> data;
            private int total_size;
            private int page_index;
            private Date min_date;
            private Date max_date;

            @Data
            @NoArgsConstructor
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Date {
                private int year;
                private int month;
                private int day;
            }
        }
    }
}
