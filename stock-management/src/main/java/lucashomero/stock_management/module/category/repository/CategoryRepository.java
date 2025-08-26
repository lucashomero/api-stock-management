package lucashomero.stock_management.module.category.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import lucashomero.stock_management.module.category.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID>{

}
