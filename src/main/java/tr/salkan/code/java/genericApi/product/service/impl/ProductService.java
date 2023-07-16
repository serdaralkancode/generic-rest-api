package tr.salkan.code.java.genericApi.product.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.salkan.code.java.genericApi.generic.service.impl.GenericService;
import tr.salkan.code.java.genericApi.product.dto.ProductDTO;
import tr.salkan.code.java.genericApi.product.mapper.IProductMapper;
import tr.salkan.code.java.genericApi.product.model.Product;
import tr.salkan.code.java.genericApi.product.repo.IProductRepository;
import tr.salkan.code.java.genericApi.product.service.IProductService;

@Service
@RequiredArgsConstructor
public class ProductService extends GenericService<Product, Long, ProductDTO, IProductRepository, IProductMapper> implements IProductService {

      //NO CODE
}
