package de.claudioaltamura.spring.boot.data.mongodb.repository;

import de.claudioaltamura.spring.boot.data.mongodb.entity.ProductMaterial;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ProductMaterialRepository extends MongoRepository<ProductMaterial, String> {

    Optional<ProductMaterial> findByMaterialNumber(String materialNumber);

}