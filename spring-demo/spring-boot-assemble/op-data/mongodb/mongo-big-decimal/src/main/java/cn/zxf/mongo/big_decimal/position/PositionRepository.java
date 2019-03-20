package cn.zxf.mongo.big_decimal.position;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PositionRepository extends MongoRepository<Position, String> {
}
