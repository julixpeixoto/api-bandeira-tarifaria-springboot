package com.bandeira.tarifaria.Bandeira.Tarifaria.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlagDto {
    private String color;
    private String value;
    private String month;
    private String year;
}
