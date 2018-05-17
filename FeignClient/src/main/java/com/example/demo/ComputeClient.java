package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("pr-service")
public interface ComputeClient {
	 @RequestMapping(method = RequestMethod.GET, value = "/add")
	    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}