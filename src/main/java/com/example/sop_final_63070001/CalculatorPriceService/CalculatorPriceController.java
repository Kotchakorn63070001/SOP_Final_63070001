package com.example.sop_final_63070001.CalculatorPriceService;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CalculatorPriceController {

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public double serviceGetProducts(@RequestBody MultiValueMap<String, String> n){
        Map<String, String> d = n.toSingleValueMap();
        double price = Double.parseDouble(d.get("cost")) + Double.parseDouble(d.get("profit"));
        System.out.println(price);
        return 0;
    }
}
