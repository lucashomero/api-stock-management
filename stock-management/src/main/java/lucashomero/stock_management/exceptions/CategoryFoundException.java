package lucashomero.stock_management.exceptions;

public class CategoryFoundException extends RuntimeException {

	public CategoryFoundException() {
		super("Category already exist.");
	}
	
	
}
