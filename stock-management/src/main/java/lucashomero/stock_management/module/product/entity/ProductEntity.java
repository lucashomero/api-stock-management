package lucashomero.stock_management.module.product.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lucashomero.stock_management.module.category.entity.CategoryEntity;

@Entity(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@NotBlank(message = "Field [name] must have a value.")
	private String name;
	
	private String description;
	
	@Positive(message = "Field [value_in_cents] must have a positive value.")
	private int value_in_cents;
	
	private int quantity;
	
	@ManyToOne()
	@JoinColumn(name = "category_id", insertable = false, nullable = false)
	private CategoryEntity categoryEntity;
	
	@Column(name = "category_id", insertable=false, updatable=false)
	private UUID categoryId;
	
}
