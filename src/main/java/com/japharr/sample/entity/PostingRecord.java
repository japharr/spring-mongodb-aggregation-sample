package com.japharr.sample.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Getter @Setter @ToString
@Builder
@Document(collection = "posting_record")
public class PostingRecord {
  private static final long serialVersionUID = 3527680327288578368L;
  @Id
  private String id;
  private String branch = "BBR";//for the whole of Ecobank
  private String homeBranch = "K01";//per-affiliate-per-scheme
  private String constant = "";
  private String constant1 = "ECOSOURCE";
  private BigDecimal fcyAmount;
  private String glAccountNo;
  private String drCr;
  private String glAccountBranch = "H98";//change per GL
  private String fcyCurrency;
  private BigDecimal lcyAmount;
  private String txCode = "F63";
  private LocalDate date;
  private BigDecimal rate;
  private String constant2 = "";
  private String narration;
  @Indexed
  private int summaryOrder;
  private boolean isControl = false;
  private boolean isNatl = false;
  private boolean isMerchandiseCredit = false;
  @Indexed
  private String postingLogId;
  private String tag;
  private Optional<Boolean> balanced;
  private boolean manualEntry = false;
}
