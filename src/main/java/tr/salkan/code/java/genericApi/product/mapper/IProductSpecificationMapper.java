package tr.salkan.code.java.genericApi.product.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import tr.salkan.code.java.genericApi.generic.mapper.IBaseMapper;
import tr.salkan.code.java.genericApi.product.dto.ProductDTO;
import tr.salkan.code.java.genericApi.product.dto.ProductSpecificationDTO;
import tr.salkan.code.java.genericApi.product.model.Product;
import tr.salkan.code.java.genericApi.product.model.ProductSpecification;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,collectionMappingStrategy = CollectionMappingStrategy.SETTER_PREFERRED)
public interface IProductSpecificationMapper extends IBaseMapper<ProductSpecification, ProductSpecificationDTO> {

    ProductSpecification mapToEntity(ProductSpecificationDTO dto);
    ProductSpecificationDTO mapToDTO(ProductSpecification productSpecification);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProgramFromDto(ProductSpecificationDTO dto, @MappingTarget ProductSpecification entity);

}
