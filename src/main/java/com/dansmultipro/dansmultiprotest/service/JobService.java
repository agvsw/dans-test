package com.dansmultipro.dansmultiprotest.service;


import com.dansmultipro.dansmultiprotest.dto.JobDTO;

public interface JobService {
    JobDTO[] getListJobs();
    JobDTO getJobById(String id);
}
