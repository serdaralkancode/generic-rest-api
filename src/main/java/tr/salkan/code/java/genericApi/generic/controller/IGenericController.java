package tr.salkan.code.java.genericApi.generic.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tr.salkan.code.java.genericApi.generic.dto.GenericDTO;
import tr.salkan.code.java.genericApi.generic.entity.GenericEntity;
import tr.salkan.code.java.genericApi.generic.response.GenericPageableResponse;
import tr.salkan.code.java.genericApi.generic.response.GenericResponse;

public interface IGenericController <T extends GenericEntity, U, D extends GenericDTO>{

    @GetMapping
    @PageableAsQueryParam
    ResponseEntity<GenericPageableResponse<D>> get(@Parameter(hidden = true) Pageable pageable);

    @GetMapping(value = "/{id}", produces = "application/json")
    ResponseEntity<GenericResponse<D>> getById(@PathVariable U id);

    @PostMapping
    ResponseEntity<GenericResponse<D>> create(@RequestBody D objDTO);

    @PutMapping("/{id}")
    ResponseEntity<GenericResponse<D>> update(@RequestBody D objDTO, @PathVariable U id);

    @DeleteMapping("/{id}")
    ResponseEntity<GenericResponse<D>> delete(@PathVariable U id);
}
