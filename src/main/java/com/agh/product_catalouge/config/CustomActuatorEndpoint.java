package com.agh.product_catalouge.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "customInfo")
public class CustomActuatorEndpoint {
    @ReadOperation
    public Map<String, Object> customData() {

        Map<String, Object> data = new HashMap<>();

        data.put("application", "Product catalogue Service");
        data.put("status", "Running");
        data.put("version", "1.0.0");

        return data;
    }
}
