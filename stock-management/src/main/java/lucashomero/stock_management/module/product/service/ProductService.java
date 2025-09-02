package lucashomero.stock_management.module.product.service;

import java.util.List;
import java.util.SortedMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import lucashomero.stock_management.exceptions.CategoryNotFoundException;
import lucashomero.stock_management.exceptions.ProductIdFoundException;
import lucashomero.stock_management.module.category.entity.CategoryEntity;
import lucashomero.stock_management.module.category.repository.CategoryRepository;
import lucashomero.stock_management.module.product.entity.ProductEntity;
import lucashomero.stock_management.module.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<ProductEntity> list(){
		Sort sort = Sort.by(Direction.ASC, "name");
		return productRepository.findAll(sort);
	}
	
	public ProductEntity create(ProductEntity productEntity){
	
		if(true) {
			if (productEntity.getId() != null) {
				throw new ProductIdFoundException();
			}
			productEntity = productRepository.save(productEntity);
		} 

		return productEntity;
		
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
