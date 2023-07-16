package tr.salkan.code.java.genericApi.generic.service.impl;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tr.salkan.code.java.genericApi.generic.dto.GenericDTO;
import tr.salkan.code.java.genericApi.generic.entity.GenericEntity;
import tr.salkan.code.java.genericApi.generic.mapper.IBaseMapper;
import tr.salkan.code.java.genericApi.generic.response.GenericPageableResponse;
import tr.salkan.code.java.genericApi.generic.response.GenericResponse;
import tr.salkan.code.java.genericApi.generic.response.GenericResponseMessage;
import tr.salkan.code.java.genericApi.generic.service.IGenericService;
import tr.salkan.code.java.genericApi.generic.service.IMessageResourceService;
import tr.salkan.code.java.genericApi.generic.respository.IGenericRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Setter
public abstract class GenericService <T extends GenericEntity, U, V extends GenericDTO, R extends IGenericRepository<T, U>, M extends IBaseMapper<T, V>> implements IGenericService<T, U, V> {

    @Autowired
    protected R repository;
    @Autowired
    protected M mapper;
    @Autowired
    protected IMessageResourceService messageSource;

    @Override
    public ResponseEntity<GenericPageableResponse<List<V>>> get(Pageable pageable) {
        try {
            Page<T> page = repository.findAll(pageable);
            List<V> dtolist = page.getContent().stream().map(obj -> {
                return mapper.mapToDTO(obj);
            }).collect(Collectors.toList());
            if (dtolist.isEmpty()) {
                return new ResponseEntity(new GenericPageableResponse(dtolist, HttpStatus.NO_CONTENT), HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(new GenericPageableResponse(dtolist, HttpStatus.OK, page.getTotalElements(), page.getTotalPages()), HttpStatus.OK);
        } catch (Exception e) {
            GenericResponseMessage message = new GenericResponseMessage();
            GenericPageableResponse failure = new GenericPageableResponse(message, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(failure, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<GenericResponse<V>> getById(U id) {
        Optional<T> obj = repository.findById(id);
        if (obj.isPresent()) {
            V objDTO = mapper.mapToDTO(obj.get());
            GenericResponse response = new GenericResponse<V>(objDTO, HttpStatus.OK);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            GenericResponseMessage message = new GenericResponseMessage();
            GenericResponse failure = new GenericResponse(message, HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(failure, HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity<GenericResponse<V>> create(V objDTO) {
        try {
            T obj = mapper.mapToEntity(objDTO);
            T createdObject = repository.save(obj);
            GenericResponse response = new GenericResponse(mapper.mapToDTO(createdObject), HttpStatus.OK);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            GenericResponse failure = new GenericResponse(messageSource.getMessage("api.error.create", null), HttpStatus.OK);
            return new ResponseEntity<>(failure, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<GenericResponse<V>> update(V objDTO, U id) {
        try {
            T obj = repository.findById(id).get();
            mapper.updateObjFromDto(objDTO, obj);
            repository.save(obj);
            GenericResponse response = new GenericResponse<V>(mapper.mapToDTO(obj), HttpStatus.CREATED);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            GenericResponse failure = new GenericResponse(messageSource.getMessage("api.error.update", null), HttpStatus.OK);
            return new ResponseEntity<>(failure, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<GenericResponse<V>> delete(U id) {

        try
        {
            T obj = repository.findById(id).get();
            repository.delete(obj);
            GenericResponse ok = new GenericResponse(null, HttpStatus.OK);
            return new ResponseEntity<>(ok, HttpStatus.OK);
        }
        catch (Exception e)
        {
            GenericResponse failure = new GenericResponse(messageSource.getMessage("api.error.delete", null), HttpStatus.OK);
            return new ResponseEntity<>(failure, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void delete(T entity) {
        repository.delete(entity);
    }

}
