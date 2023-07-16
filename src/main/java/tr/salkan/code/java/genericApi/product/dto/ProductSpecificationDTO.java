package tr.salkan.code.java.genericApi.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.salkan.code.java.genericApi.generic.dto.GenericDTO;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSpecificationDTO extends GenericDTO {

    private String name;
    private Long productId;
}
