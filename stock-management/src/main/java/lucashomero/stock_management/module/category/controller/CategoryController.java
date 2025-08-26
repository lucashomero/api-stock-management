package lucashomero.stock_management.module.category.controller;

import java.util.List;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lucashomero.stock_management.module.category.entity.CategoryEntity;
import lucashomero.stock_management.module.category.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<Object> list(){
		var allCategorys = categoryService.list();
		return ResponseEntity.ok().body(allCategorys);
	}
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody @Valid CategoryEntity categoryEntity){
		
		try {
			var category = categoryService.create(categoryEntity);
			return ResponseEntity.ok().body(category);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody CategoryEntity categoryEntity){
		
		try {
			var category = categoryService.update(id, categoryEntity);
			return ResponseEntity.ok().body(category);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id){
		
		try {
			categoryService.delete(id);
			return ResponseEntity.ok().body(list());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}

	
}
