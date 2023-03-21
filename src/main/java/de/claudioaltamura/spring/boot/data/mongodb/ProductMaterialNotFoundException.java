package de.claudioaltamura.spring.boot.data.mongodb;

public class ProductMaterialNotFoundException extends RuntimeException {

	public ProductMaterialNotFoundException(String message) {
		super(message);
	}

}
