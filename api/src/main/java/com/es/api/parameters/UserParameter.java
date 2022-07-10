package com.es.api.parameters;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserParameter {

    @JsonProperty("userId")
    @ApiModelProperty(required = true)
    private String userId;

    @JsonProperty("regNo")
    @ApiModelProperty(required = true)
    private String regNo;
    @JsonProperty("password")
    @ApiModelProperty(required = true)
    private String password;
    @JsonProperty("name")
    @ApiModelProperty(required = true)
    private String name;
}
