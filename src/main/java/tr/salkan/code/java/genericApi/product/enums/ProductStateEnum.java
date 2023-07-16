package tr.salkan.code.java.genericApi.product.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tr.salkan.code.java.genericApi.generic.converter.GenericEnumConverter;
import tr.salkan.code.java.genericApi.generic.enums.GenericPersistableEnum;

@AllArgsConstructor
@Getter
public enum ProductStateEnum implements GenericPersistableEnum<Integer> {

    DISCOUNTED( 1,"Discounted"),
    NEW( 2,"New"),
    PROMOTIONAL( 3,"Promotional"),
    OUT_OF_STOCK(4,"Out of Stock");

    private Integer value;
    private String text;


    public static class Converter extends GenericEnumConverter<ProductStateEnum, Integer> {
        public Converter() {
            super(ProductStateEnum.class);
        }
    }

}
