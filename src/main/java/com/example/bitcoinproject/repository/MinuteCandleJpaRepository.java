package com.example.bitcoinproject.repository;

import com.example.bitcoinproject.entity.FiveMinuteCandle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiveMinuteCandleJpaRepository extends JpaRepository<FiveMinuteCandle, Long> {
}
