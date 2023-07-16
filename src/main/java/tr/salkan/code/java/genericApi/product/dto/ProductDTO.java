package tr.salkan.code.java.genericApi.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.salkan.code.java.genericApi.generic.dto.GenericDTO;
import tr.salkan.code.java.genericApi.product.enums.ProductStateEnum;
import tr.salkan.code.java.genericApi.product.model.ProductSpecification;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends GenericDTO {

    private String name;
    private String code;
    private ProductStateEnum productState;
    private List<ProductSpecificationDTO> productSpecificationList = new ArrayList<>();
}
