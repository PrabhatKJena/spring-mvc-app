package in.consultit.handler.impl;

import in.consultit.handler.Handler;
import in.consultit.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductHandler implements Handler {
    @Override
    public List<Product> doHandle(Product form) {
        List<Product> list = new ArrayList<Product>();

        Product p = new Product();
        p.setPrice(1000d);
        p.setProductId("P001");
        p.setProductType("FOOD");
        p.setStatus("Available");
        list.add(p);

        p = new Product();
        p.setPrice(300d);
        p.setProductId("P002");
        p.setProductType("Stationary");
        p.setStatus("Available");
        list.add(p);
        return list;
    }
}
