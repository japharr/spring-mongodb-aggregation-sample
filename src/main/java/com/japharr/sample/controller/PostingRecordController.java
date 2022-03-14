package com.japharr.sample.controller;

import com.japharr.sample.model.AggResult;
import com.japharr.sample.service.PostingRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/posting-records")
public class PostingRecordController {
  @Autowired
  private PostingRecordService service;

  @GetMapping
  public AggResult aggResult() {
    log.info("get aggregate");
    return service.aggregate();
  }

  @PostMapping
  public AggResult aggResult2() {
    log.info("post aggregate");
    Set<String> logIds = new HashSet<>();
    Set<String> tags = new HashSet<>();

    logIds.add("6189f9467ea9e9bcd1fd8ce4");
    tags.add("DUAL-POS ACQUIRER ITEM");

    return service.aggregate(logIds, tags);
  }
}
