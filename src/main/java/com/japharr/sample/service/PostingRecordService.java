package com.japharr.sample.service;

import com.japharr.sample.model.AggResult;
import com.japharr.sample.repository.PostingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PostingRecordService {
  @Autowired
  private PostingRecordRepository repository;

  public AggResult aggregate() {
    return repository.agg();
  }

  public AggResult aggregate(Set<String> postingLogIds, Set<String> tags) {
    return repository.agg(postingLogIds, tags);
  }
}
