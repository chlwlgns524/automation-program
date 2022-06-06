package com.example.bitcoinproject.repository;

import com.example.bitcoinproject.entity.FiveMinuteCandleOnMay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandleJpaRepository extends JpaRepository<FiveMinuteCandleOnMay, Long> {
}
