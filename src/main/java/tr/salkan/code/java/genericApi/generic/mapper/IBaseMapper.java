package tr.salkan.code.java.genericApi.generic.mapper;

import tr.salkan.code.java.genericApi.generic.dto.GenericDTO;
import tr.salkan.code.java.genericApi.generic.entity.GenericEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
public interface IBaseMapper <S extends GenericEntity, DTO extends GenericDTO> {

    S mapToEntity(DTO dto);

    DTO mapToDTO(S obj);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateObjFromDto(DTO dto, @MappingTarget S entity);
}
