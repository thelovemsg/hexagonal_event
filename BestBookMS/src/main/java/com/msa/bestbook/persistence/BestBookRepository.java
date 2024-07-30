package com.msa.bestbook.persistence;

import com.msa.bestbook.domain.model.BestBook;
import com.msa.bestbook.domain.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BestBookRepository extends MongoRepository<BestBook, String> {
    BestBook findBestBookByItem(Item item);
}
