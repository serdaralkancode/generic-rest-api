package tr.salkan.code.java.genericApi.product.service;

import tr.salkan.code.java.genericApi.generic.service.IGenericService;
import tr.salkan.code.java.genericApi.product.dto.ProductDTO;
import tr.salkan.code.java.genericApi.product.model.Product;

public interface IProductService extends IGenericService<Product, Long, ProductDTO> {
}
