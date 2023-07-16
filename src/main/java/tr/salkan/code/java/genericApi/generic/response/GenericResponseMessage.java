package tr.salkan.code.java.genericApi.generic.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class GenericResponseMessage implements Serializable {

    private String title;
    private String details;
    private String exception;
}
