package com.df.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author feng.dai
 * @package com.df.fallback
 * @project get_parent_master
 * @Date 2022/9/20 16:22
 */
@Component
public class ConsumerFallBack implements FallbackProvider {

    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

        return new ClientHttpResponse() {

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return null;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 0;
            }

            @Override
            public String getStatusText() throws IOException {
                return null;
            }

            @Override
            public void close() {

            }

            /**
             * 返回托底数据
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                //设置返回的托底数据
                String msg = route + ": The service is unavailable, please contact the administrator!";
                return new ByteArrayInputStream(msg.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
