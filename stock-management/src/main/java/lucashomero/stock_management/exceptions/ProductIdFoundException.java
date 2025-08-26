package lucashomero.stock_management.exceptions;

public class ProductIdFoundException extends RuntimeException {

	public ProductIdFoundException() {
		super("Product with same Id already exist.");
	}

	
	
}
