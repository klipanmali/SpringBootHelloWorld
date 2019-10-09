package my.springboot.hello.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import my.springboot.hello.exceptionhandling.ProductNotFoundException;
import my.springboot.hello.model.Product;

@Service
public class ProdcutServiceImpl implements ProductService {

	private static final Logger logger = LoggerFactory
			.getLogger(ProdcutServiceImpl.class);

	private static Map<String, Product> productRepo = new HashMap<>();

	static {
		Product honey = new Product("1", "Honey");
		Product almond = new Product("2", "Almond");
		productRepo.put(honey.getId(), honey);
		productRepo.put(almond.getId(), almond);
	}

	@Override
	public Collection<Product> getProducts() {
		return productRepo.values();
	}

	@Override
	public Product createProduct(Product product) {
		productRepo.put(product.getId(), product);
		logger.info("New " + product + " created");
		return product;
	}

	@Override
	public Product updateProduct(String id, Product product) {
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
		logger.info(product + " updated");
		return product;
	}

	@Override
	public Collection<Product> deleteProduct(String id) {
		if (!productRepo.containsKey(id))
			throw new ProductNotFoundException();
		Product productToRemove = productRepo.get(id);
		productRepo.remove(id);
		logger.info(productToRemove + " removed");
		return productRepo.values();
	}

}
