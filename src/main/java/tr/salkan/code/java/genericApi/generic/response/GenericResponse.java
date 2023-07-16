package tr.salkan.code.java.genericApi.generic.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class GenericResponse <T> implements Serializable {

    private HttpStatus status;
    private T data;
    private GenericResponseMessage message;

    public GenericResponse() throws InstantiationException {
        throw new InstantiationException("can not create instantiation");
    }

    public GenericResponse(T data, HttpStatus status) {
        this.data = data;
        this.status = status;
    }

    public GenericResponse(GenericResponseMessage message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
