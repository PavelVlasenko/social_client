package social_client.controllers;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import social_client.ClientConfiguration;

@RestController
@RibbonClient(name = "social_client", configuration = ClientConfiguration.class)

public class TestController {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String hi() {
        return restTemplate().getForObject("http://social_client/test", String.class);
    }

}