package com.example.bitcoinproject.repository;

import com.example.bitcoinproject.entity.DayCandle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayCandleJpaRepository extends JpaRepository<DayCandle, Long> {
}
