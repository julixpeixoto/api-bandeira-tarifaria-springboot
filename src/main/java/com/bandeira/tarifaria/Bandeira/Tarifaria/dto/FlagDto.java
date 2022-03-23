package com.bandeira.tarifaria.Bandeira.Tarifaria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlagDto {
    private String color;
    private String value;
    private String month;
    private String year;
}
