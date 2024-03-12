package ru.itis.okno.backend.services.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class HashGenerator {

    public String hash(String data) {
        return DigestUtils
                .md5Hex(data);
    }
}
