package lucashomero.stock_management.module.category.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import lucashomero.stock_management.exceptions.CategoryFoundException;
import lucashomero.stock_management.exceptions.CategoryNotFoundException;
import lucashomero.stock_management.module.category.entity.CategoryEntity;
import lucashomero.stock_management.module.category.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public List<CategoryEntity> list(){
		
		Sort sort = Sort.by(Direction.ASC, "name");
		return categoryRepository.findAll(sort);
		
	}
	
	public CategoryEntity create(CategoryEntity categoryEntity) {
		
		var category = categoryRepository.findByName(categoryEntity.getName());
		if (category.isPresent()) {
			throw new CategoryFoundException();
		}
		
		categoryRepository.save(categoryEntity);
		return categoryEntity;
		
	}

	public CategoryEntity update(UUID id, CategoryEntity categoryEntity) {
		
		Optional<CategoryEntity> category = categoryRepository.findById(id);
		
		if(category.isPresent()) {
			categoryEntity.setId(id);
			categoryRepository.save(categoryEntity);
		} else {
			throw new CategoryNotFoundException();
		}
		
		return categoryEntity;
	}
	
	public void delete(UUID id) {
		
		Optional<CategoryEntity> category = categoryRepository.findById(id);
		categoryRepository.deleteById(id);
		
	}
	
	
}
