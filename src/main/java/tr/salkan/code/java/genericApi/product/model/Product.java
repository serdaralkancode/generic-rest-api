package tr.salkan.code.java.genericApi.product.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.salkan.code.java.genericApi.generic.entity.GenericEntity;
import tr.salkan.code.java.genericApi.product.enums.ProductStateEnum;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends GenericEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "product_state")
    @Convert(converter = ProductStateEnum.Converter.class)
    private ProductStateEnum productState;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductSpecification> productSpecificationList = new ArrayList<>();


    public Product(Long id) {
        super(id);
    }
}
