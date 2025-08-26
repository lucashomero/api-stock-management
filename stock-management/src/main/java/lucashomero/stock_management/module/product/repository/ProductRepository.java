package lucashomero.stock_management.module.product.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import lucashomero.stock_management.module.category.entity.CategoryEntity;
import lucashomero.stock_management.module.product.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
	Optional<ProductEntity> findByName(String name);
}
