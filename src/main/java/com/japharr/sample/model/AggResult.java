package com.japharr.sample.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AggResult {
  private BigDecimal totalAmount;
  private Long count;
}
