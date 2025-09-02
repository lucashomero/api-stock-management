package lucashomero.stock_management.module.product.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.val;
import lucashomero.stock_management.module.product.entity.ProductEntity;
import lucashomero.stock_management.module.product.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping
	public ResponseEntity<Object> list(){
		var getProducts = productService.list();
		return ResponseEntity.ok().body(getProducts);
	}
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody @Valid ProductEntity productEntity){
	
		try {
			var createProduct = productService.create(productEntity);
			return ResponseEntity.ok().body(createProduct);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody @Valid ProductEntity productEntity){
		
		try {
			var updateProduct = productService.update(productEntity);
			return ResponseEntity.ok().body(updateProduct);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id){
		
		try {
			var deleteProduct = productService.delete(id);
			return ResponseEntity.ok().body(deleteProduct);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	
	
	
	
	 
	
	
}
