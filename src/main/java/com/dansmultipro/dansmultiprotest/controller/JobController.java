package com.dansmultipro.dansmultiprotest.controller;

import com.dansmultipro.dansmultiprotest.dto.CommonResponse;
import com.dansmultipro.dansmultiprotest.dto.JobDTO;
import com.dansmultipro.dansmultiprotest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobs")
    public CommonResponse<JobDTO[]> getListJob(){
        CommonResponse<JobDTO[]> response = new CommonResponse<>();
        response.setData(jobService.getListJobs());
        return response;
    }

    @GetMapping("job/{id}")
    public CommonResponse<JobDTO> getListJob(@PathVariable String id){
        CommonResponse<JobDTO> response = new CommonResponse<>();
        response.setData(jobService.getJobById(id));
        return response;
    }
}
