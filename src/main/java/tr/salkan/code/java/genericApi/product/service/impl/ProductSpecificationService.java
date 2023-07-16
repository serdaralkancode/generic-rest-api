package tr.salkan.code.java.genericApi.product.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.salkan.code.java.genericApi.generic.service.impl.GenericService;
import tr.salkan.code.java.genericApi.product.dto.ProductSpecificationDTO;
import tr.salkan.code.java.genericApi.product.mapper.IProductSpecificationMapper;
import tr.salkan.code.java.genericApi.product.model.ProductSpecification;
import tr.salkan.code.java.genericApi.product.repo.IProductSpecificationRepository;
import tr.salkan.code.java.genericApi.product.service.IProductSpecificationService;

@Service
@RequiredArgsConstructor
public class ProductSpecificationService extends GenericService<ProductSpecification, Long, ProductSpecificationDTO, IProductSpecificationRepository, IProductSpecificationMapper> implements IProductSpecificationService {



}
