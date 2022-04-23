package com.cubicfox.configs;

import com.cubicfox.exceptions.FeignClientException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FeignConfig extends ErrorDecoder.Default {
    private static final Logger LOG = LoggerFactory.getLogger(FeignConfig.class);

    private final ObjectMapper objectMapper;

    public FeignConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean
    public Decoder feignDecoder() {
        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() >= 400 && response.status() <= 599) {
            String content = null;
            try {
                Response.Body body = response.body();
                if (body == null) {
                    return new FeignClientException("Feign response body is null or not valid", response.status());
                } else {
                    content = IOUtils.toString(body.asReader(StandardCharsets.UTF_8));
                }
            } catch (IOException e) {
                LOG.warn("Cannot read Feign response body: " + e.getMessage(), e);
            }
            return new FeignClientException(content, response.status());
        }
        return super.decode(methodKey, response);
    }
}
