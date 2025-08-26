package lucashomero.stock_management.module.product.service;

import java.util.List;
import java.util.SortedMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import lucashomero.stock_management.exceptions.ProductIdFoundException;
import lucashomero.stock_management.module.product.entity.ProductEntity;
import lucashomero.stock_management.module.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductEntity> list(){
		Sort sort = Sort.by(Direction.ASC, "name").and(Sort.by(Direction.ASC, "value_in_cents"));
		return productRepository.findAll(sort);
	}
	
	public List<ProductEntity> create(ProductEntity productEntity){
		
		var product = productRepository.findById(productEntity.getId());
		if (product.isPresent()) {
			throw new ProductIdFoundException();
		}
		
		productRepository.save(productEntity);
		return list();
		
		
	}
	
	public List<ProductEntity> update(UUID id, ProductEntity productEntity){
		
		var product = productRepository.findById(id);
		if (product.isPresent()) {
			productEntity.setId(id);
			productRepository.save(productEntity);
		}
		
		return list();
		
	}
	
	
	
	public List<ProductEntity> delete(UUID id){
		var product = productRepository.findById(id);
		if (product.isPresent()) {
			productRepository.deleteById(id);
		}
		return list();
	}
	
}
