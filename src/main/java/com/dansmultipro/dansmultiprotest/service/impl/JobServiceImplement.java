package com.dansmultipro.dansmultiprotest.service.impl;

import com.dansmultipro.dansmultiprotest.dto.JobDTO;
import com.dansmultipro.dansmultiprotest.service.JobService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class JobServiceImplement implements JobService {

    @Value("${base-url}")
    private String baseUrl;


    @Override
    public JobDTO[] getListJobs() {
        String output = getDataService(null);
        Gson gson = new Gson();
        return gson.fromJson(output, JobDTO[].class);
    }

    @Override
    public JobDTO getJobById(String id) {
        String output = getDataService(id);
        Gson gson = new Gson();
        return gson.fromJson(output, JobDTO.class);
    }

    private String getDataService(String id){
        String pathUrl = baseUrl + (id == null ?  "/recruitment/positions.json" : "/recruitment/positions/"+ id);

        try {
            URL url = new URL(pathUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output = br.readLine();
            conn.disconnect();
            return output;
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        return null;
    }
}
