package com.example.bitcoinproject.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Setter
@Getter
public class OrderDTO {

      String uuid;

      String side;

      @JsonProperty(value = "ord_type")
      String ordType;

      String price;

      @JsonProperty(value = "avg_price")
      String avgPrice;

      String state;

      String market;

      @JsonProperty(value = "created_at")
      String createdAt;

      String volume;

      @JsonProperty(value = "remaining_volume")
      String remainingVolume;

      @JsonProperty(value = "reserved_fee")
      String reservedFee;

      @JsonProperty(value = "remaining_fee")
      String remainingFee;

      @JsonProperty(value = "paid_fee")
      String paidFee;

      String locked;

      @JsonProperty(value = "executed_volume")
      String executedVolume;

      @JsonProperty(value = "trades_count")
      String tradesCount;

}
