package in.consultit.handler.impl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import in.consultit.handler.ServiceHandler;
import in.consultit.model.Product;
import in.consultit.model.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceHandler implements  ServiceHandler {
    static Client client = Client.create();
    private static final String productFindUrl = "http://localhost:8081/rest/productSvc/findProduct/";

    public List<Product> doHandle(Product form) {
        List<Product> list = new ArrayList<Product>();
        WebResource webResource = client.resource(productFindUrl+form.getProductId());
        ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("HTTP Error: " + response.getStatus());
        }
        ProductResponse productResponse = response.getEntity(ProductResponse.class);
        return productResponse.getProductList();
    }

}
