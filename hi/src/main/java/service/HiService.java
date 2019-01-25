package service;

import org.springframework.web.bind.annotation.GetMapping;

public interface HiService {
    @GetMapping("/hi")
    String hi();
}
