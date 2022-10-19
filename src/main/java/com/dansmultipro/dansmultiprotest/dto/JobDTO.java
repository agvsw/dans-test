package com.dansmultipro.dansmultiprotest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobDTO {
    private String id;
    private String type;
    private String url;
    @JsonProperty("createdAt")
    private String created_at;
    private String company;
    @JsonProperty("companyUrl")
    private String company_url;
    private String location;
    private String title;
    private String description;
    @JsonProperty("howtoApply")
    private String how_to_apply;
    @JsonProperty("companyLogo")
    private String company_logo;
}
