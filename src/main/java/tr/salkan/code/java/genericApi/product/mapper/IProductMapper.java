package tr.salkan.code.java.genericApi.product.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import tr.salkan.code.java.genericApi.generic.mapper.IBaseMapper;
import tr.salkan.code.java.genericApi.product.dto.ProductDTO;
import tr.salkan.code.java.genericApi.product.model.Product;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,collectionMappingStrategy = CollectionMappingStrategy.SETTER_PREFERRED)
public interface IProductMapper extends IBaseMapper<Product, ProductDTO> {

    Product mapToEntity(ProductDTO dto);
    ProductDTO mapToDTO(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProgramFromDto(ProductDTO dto, @MappingTarget Product entity);
}
