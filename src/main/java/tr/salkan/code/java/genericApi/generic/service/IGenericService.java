package tr.salkan.code.java.genericApi.generic.service;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import tr.salkan.code.java.genericApi.generic.dto.GenericDTO;
import tr.salkan.code.java.genericApi.generic.entity.GenericEntity;
import tr.salkan.code.java.genericApi.generic.response.GenericPageableResponse;
import tr.salkan.code.java.genericApi.generic.response.GenericResponse;

import java.util.List;

public interface IGenericService <T extends GenericEntity, U, V extends GenericDTO> {
    ResponseEntity<GenericResponse<V>> getById(U id);

    ResponseEntity<GenericResponse<V>> create(V objDTO);

    ResponseEntity<GenericResponse<V>> update(V portfolioDTO, U id);

    ResponseEntity<GenericPageableResponse<List<V>>> get(Pageable pageable);

    ResponseEntity<GenericResponse<V>> delete(U id);
}
