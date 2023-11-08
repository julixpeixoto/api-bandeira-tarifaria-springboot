package com.bandeira.tarifaria.Bandeira.Tarifaria.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "flag_data")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlagModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name = "year_number", nullable = false)
    private String year;

    @Column(name = "flag", nullable = false)
    private String flag;

    @Column(name = "month_text", nullable = false)
    private String monthText;

    @Column(name = "month_number", nullable = false)
    private Integer month;

    @Column(name = "factor", nullable = false)
    private String factor;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
