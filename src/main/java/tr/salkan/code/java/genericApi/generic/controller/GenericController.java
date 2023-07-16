package tr.salkan.code.java.genericApi.generic.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import tr.salkan.code.java.genericApi.generic.dto.GenericDTO;
import tr.salkan.code.java.genericApi.generic.entity.GenericEntity;
import tr.salkan.code.java.genericApi.generic.response.GenericPageableResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import tr.salkan.code.java.genericApi.generic.response.GenericResponse;
import tr.salkan.code.java.genericApi.generic.service.IGenericService;

public abstract class GenericController <T extends GenericEntity, U, D extends GenericDTO, S extends IGenericService> implements IGenericController<T, U, D> {

    @Autowired
    public S service;

    public ResponseEntity<GenericPageableResponse<D>> get(@Parameter(hidden = true) Pageable pageable) {
        return service.get(pageable);
    }

    public ResponseEntity<GenericResponse<D>> getById(@PathVariable U id) {
        return service.getById(id);
    }

    public ResponseEntity<GenericResponse<D>> create(D objDTO) {
        return service.create(objDTO);
    }

    @Override
    public ResponseEntity<GenericResponse<D>> update(D objDTO, U id) {
        return service.update(objDTO, id);
    }

    @Override
    public ResponseEntity<GenericResponse<D>> delete(U id) {
        return service.delete(id);
    }

}
