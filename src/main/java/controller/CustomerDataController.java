package controller;

import entity.CustomerData;
import org.springframework.web.bind.annotation.*;
import service.CustomerDataService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerDataController {

    private final CustomerDataService customerDataService;

    public CustomerDataController(CustomerDataService customerDataService){
        this.customerDataService = customerDataService;
    }

    @GetMapping
    public List<CustomerData> getAll(){
        return customerDataService.getAll();
    }

    @PostMapping
    public CustomerData create(@RequestBody CustomerData customerData){
        return customerDataService.save(customerData);
    }
}
