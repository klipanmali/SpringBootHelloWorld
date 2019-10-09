package my.springboot.hello.service;

import java.util.Collection;

import my.springboot.hello.model.Product;

public interface ProductService {

	public Collection<Product> getProducts();
	public Product createProduct(Product product);
	public Product updateProduct(String id, Product product);
	public Collection<Product> deleteProduct(String id);

}
