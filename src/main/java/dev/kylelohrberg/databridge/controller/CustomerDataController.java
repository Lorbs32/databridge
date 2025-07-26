package dev.kylelohrberg.databridge.controller;

import dev.kylelohrberg.databridge.entity.CustomerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.kylelohrberg.databridge.service.CustomerDataService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerDataController {

    @Autowired
    private final CustomerDataService customerDataService;

    public CustomerDataController(CustomerDataService customerDataService){
        this.customerDataService = customerDataService;
    }

    // GET request to display all Customers
    @GetMapping
    public List<CustomerData> getAllCustomers(){
        return customerDataService.getAll();
    }

    // POST request to save a new Customer
    @PostMapping
    public CustomerData createCustomer(@RequestBody CustomerData customerData){
        return customerDataService.save(customerData);
    }

    // GET request to look up Customer by id
    @GetMapping("/{id}")
    public ResponseEntity<CustomerData> getCustomerById(@PathVariable Long id){
        return customerDataService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT request to edit a Customer by id
    @PutMapping("/{id}")
    public ResponseEntity<CustomerData> updateCustomer(@PathVariable Long id, @RequestBody CustomerData updatedData){
        return customerDataService.update(id, updatedData)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE request to delete Customer by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        if (customerDataService.delete(id)){
            return ResponseEntity.noContent().build(); //204
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
