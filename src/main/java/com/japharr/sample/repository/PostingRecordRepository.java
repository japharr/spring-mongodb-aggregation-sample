package com.japharr.sample.repository;

import com.japharr.sample.entity.PostingRecord;
import com.japharr.sample.model.AggResult;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PostingRecordRepository extends MongoRepository<PostingRecord, String> {

  @Aggregation(pipeline = {
      "{" +
          "      '$match': { $and: [ " +
          "          { 'postingLogId': {'$in': ['6189f9467ea9e9bcd1fd8ce4']} }, " +
          "          { 'tag': {'$nin': ['DUAL-POS ACQUIRER ITEM'] } }" +
          "       ]}" +
          "  }",
      "{" +
          "    '$group': {" +
          "      '_id': null," +
          "      'totalAmount': {" +
          "        '$sum': {" +
          "          '$cond': [ { '$eq': [ '$drCr', 'C' ] }, {'$toDouble': '$lcyAmount'}, {'$multiply': [{'$toDouble': '$lcyAmount'}, -1]} ]" +
          "        }" +
          "      }," +
          "      'count': {" +
          "        '$sum': 1" +
          "      }" +
          "    }" +
          "  }"
  })
  AggResult agg();

  @Aggregation(pipeline = {
      "{" +
          "      '$match': { $and: [ " +
          "          { 'postingLogId': {'$in': ?0} }, " +
          "          { 'tag': {'$nin': ?1} }" +
          "       ]}" +
          "  }",
      "{" +
          "    '$group': {" +
          "      '_id': null," +
          "      'totalAmount': {" +
          "        '$sum': {" +
          "          '$cond': [ { '$eq': [ '$drCr', 'C' ] }, {'$toDouble': '$lcyAmount'}, {'$multiply': [{'$toDouble': '$lcyAmount'}, -1]} ]" +
          "        }" +
          "      }," +
          "      'count': {" +
          "        '$sum': 1" +
          "      }" +
          "    }" +
          "  }"
  })
  AggResult agg(Set<String> postingLogIds, Set<String> tags);
}
