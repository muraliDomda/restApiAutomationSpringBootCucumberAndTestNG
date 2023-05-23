package com.sa.demo.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ScenarioContext {


        private Map<String, Object> context = new HashMap<>();

        public void setContext(String key, Object value) {
            context.put(key, value);
        }

        public Object getContext(String key) {
            return context.get(key);
        }

        public Boolean containsContext(String key) {
            return context.containsKey(key);
        }


}
