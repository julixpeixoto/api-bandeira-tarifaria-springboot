package com.bandeira.tarifaria.Bandeira.Tarifaria.repository;

import com.bandeira.tarifaria.Bandeira.Tarifaria.model.FlagModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlagRepository extends JpaRepository<FlagModel, String> {
    FlagModel findByMonthTextAndYear(String month, String year);
    List<FlagModel> findAllByOrderByYearDescMonthDesc();
}
