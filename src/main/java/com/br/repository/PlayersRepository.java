package com.br.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.model.mongo.Players;

public interface PlayersRepository extends MongoRepository<Players, ObjectId>{

	
	
}
