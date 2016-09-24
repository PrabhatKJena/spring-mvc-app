package in.consultit.handler;

import in.consultit.model.Product;

import java.util.List;

/**
 * Created by prajena on 9/24/16.
 */
public interface ServiceHandler {
    List<Product> doHandle(Product form);
}
