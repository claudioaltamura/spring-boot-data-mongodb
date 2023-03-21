package de.claudioaltamura.spring.boot.data.mongodb.controller;

import de.claudioaltamura.spring.boot.data.mongodb.ProductMaterialNotFoundException;
import de.claudioaltamura.spring.boot.data.mongodb.entity.ProductMaterial;
import de.claudioaltamura.spring.boot.data.mongodb.repository.ProductMaterialRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_materials")
public class ProductMaterialController {

    public static final String PRODUCT_MATERIAL_ID_S_NOT_FOUND = "ProductMaterial (id=%s) not found.";
    private final ProductMaterialRepository productMaterialRepository;

    public ProductMaterialController(ProductMaterialRepository productMaterialRepository) {
        this.productMaterialRepository = productMaterialRepository;
    }


    @GetMapping
    public ResponseEntity<List<ProductMaterial>> getAll() {
        return new ResponseEntity<>(productMaterialRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductMaterial> getById(@PathVariable("id") String id) {
        final var productMaterial = productMaterialRepository.findById(id);

        return productMaterial.map(material -> new ResponseEntity<>(material, HttpStatus.OK)).orElseThrow(() -> new ProductMaterialNotFoundException(String.format(PRODUCT_MATERIAL_ID_S_NOT_FOUND, id)));
    }

    @GetMapping("/materialNumber/{id}")
    public ResponseEntity<ProductMaterial> getByMaterialNumber(@PathVariable("id") String id) {
        final var productMaterial = productMaterialRepository.findByMaterialNumber(id);

        return productMaterial.map(material -> new ResponseEntity<>(material, HttpStatus.OK)).orElseThrow(() -> new ProductMaterialNotFoundException(String.format(PRODUCT_MATERIAL_ID_S_NOT_FOUND, id)));
    }

    @PostMapping
    public ResponseEntity<ProductMaterial> create(@RequestBody ProductMaterial newProductMaterial) {
        final var productMaterial = productMaterialRepository.save(new ProductMaterial(newProductMaterial.getMaterialNumber(), newProductMaterial.getName(), newProductMaterial.getDescription(), newProductMaterial.getPrice()));
        return new ResponseEntity<>(productMaterial, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductMaterial> update(@PathVariable("id") String id, @RequestBody ProductMaterial changedProductMaterial) {
        final var productMaterial = productMaterialRepository.findById(id);

        if (productMaterial.isPresent()) {
            ProductMaterial newpProductMaterial = productMaterial.get();
            newpProductMaterial.setMaterialNumber(changedProductMaterial.getMaterialNumber());
            newpProductMaterial.setDescription(changedProductMaterial.getDescription());
            newpProductMaterial.setName(changedProductMaterial.getName());
            newpProductMaterial.setPrice(changedProductMaterial.getPrice());
            return new ResponseEntity<>(productMaterialRepository.save(newpProductMaterial), HttpStatus.OK);
        } else {
            throw new ProductMaterialNotFoundException(String.format(PRODUCT_MATERIAL_ID_S_NOT_FOUND, id));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") String id) {
        productMaterialRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteAll() {
        productMaterialRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}