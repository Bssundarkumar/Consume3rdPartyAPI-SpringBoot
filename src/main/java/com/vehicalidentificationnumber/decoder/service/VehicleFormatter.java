package com.vehicalidentificationnumber.decoder.service;

import com.vehicalidentificationnumber.decoder.model.Vin;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VehicleFormatter {

    public Map<String, String> getDetails(Vin vin){
        Map<String, String> stringStringMap = new HashMap<>();
        vin.getResultsList().forEach(x->{
            String s = "";
            if(x.getValue()!=null) {
                 s = x.getValue();
            }
            if(s != "null" && !s.isEmpty() && s.length() !=0) {
                stringStringMap.put(x.getVariable(), x.getValue());
            }
        });
        return stringStringMap;
    }
}
