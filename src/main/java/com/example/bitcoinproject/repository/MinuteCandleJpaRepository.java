package com.example.bitcoinproject.repository;

import com.example.bitcoinproject.entity.MinuteCandle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinuteCandleJpaRepository extends JpaRepository<MinuteCandle, Long> {
}
