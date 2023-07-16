package tr.salkan.code.java.genericApi.generic.service;

import jakarta.annotation.Nullable;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

public interface IMessageResourceService {

    String getMessage(String code, @Nullable Object[] args, Locale locale) throws NoSuchMessageException;

    String getMessage(String code, @Nullable Object[] args) throws NoSuchMessageException;

    String getMessage(String code);

}
