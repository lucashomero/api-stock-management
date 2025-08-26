package lucashomero.stock_management.exceptions;

public class CategoryNotFoundException extends RuntimeException{

	public CategoryNotFoundException() {
		super("Category does not exist.");
	}
	
}
