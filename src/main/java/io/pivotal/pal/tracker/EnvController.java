package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class EnvController {

    private Map<String, String> env = new HashMap<String, String>();

    @Autowired
    public EnvController(@Value("${PORT:NOT SET}")String port, @Value("${MEMORY_LIMIT:NOT SET}")String memoryLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}")String instance, @Value("${CF_INSTANCE_ADDR:NOT SET}")String address) {
        this.env.put("PORT", port);
        this.env.put("MEMORY_LIMIT", memoryLimit);
        this.env.put("CF_INSTANCE_INDEX", instance);
        this.env.put("CF_INSTANCE_ADDR", address);
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        return this.env;
    }

}