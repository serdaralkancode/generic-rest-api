package tr.salkan.code.java.genericApi.generic.service.impl;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import tr.salkan.code.java.genericApi.generic.service.IMessageResourceService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageResourceService implements IMessageResourceService {

    private static Map<String, Locale> localeMap = new HashMap<>();
    public static Locale DEFAULT_LOCALE = new Locale("tr", "TR");

    static {
        localeMap.put("tr", new Locale("tr", "TR"));
        localeMap.put("en", new Locale("en", "US"));
    }

    private final MessageSource messageSource;



    public String getMessage(String code, @Nullable Object[] args, Locale locale) {
        return messageSource.getMessage(code, args, locale);
    }

    public String getMessage(String code, @Nullable Object[] args) {
        return messageSource.getMessage(code, args, resolveLocale());
    }

    public String getMessage(String code) {
        return messageSource.getMessage(code, null, resolveLocale());
    }

    public Locale resolveLocale() {

        Locale locale = DEFAULT_LOCALE;
        return locale;
    }
}
