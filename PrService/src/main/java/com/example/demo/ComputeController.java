package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class ComputeController {

	 @Autowired
	    private DiscoveryClient client;

	    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
	    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
	        Integer r = a + b;
	        for( String s :  client.getServices()){  
	            System.out.println("services " + s);  
	            List<ServiceInstance> serviceInstances =  client.getInstances(s);  
	            for(ServiceInstance si : serviceInstances){  
	                System.out.println("    services:" + s + ":getHost()=" + si.getHost());  
	                System.out.println("    services:" + s + ":getPort()=" + si.getPort());  
	                System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());  
	                System.out.println("    services:" + s + ":getUri()=" + si.getUri());  
	                System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());  
	            } 
	        }
	        return r;
	    }

}