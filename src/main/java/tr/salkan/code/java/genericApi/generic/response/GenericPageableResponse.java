package tr.salkan.code.java.genericApi.generic.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class GenericPageableResponse<T> extends GenericResponse<T> implements Serializable {

    public GenericPageableResponse() throws InstantiationException {
        super();
    }

    private Long totalCount;
    private int totalPage;

    public GenericPageableResponse(T data, HttpStatus status) {
        super(data, status);
    }

    public GenericPageableResponse(T data, HttpStatus status, Long totalCount) {
        super(data, status);
        this.totalCount = totalCount;
    }

    public GenericPageableResponse(T data, HttpStatus status, Long totalCount, int totalPage) {
        super(data, status);
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }

    public GenericPageableResponse(GenericResponseMessage message, HttpStatus status) {
        super(message, status);
    }

}
