package service;

import entity.CustomerData;
import org.springframework.stereotype.Service;
import repository.CustomerDataRepository;

import java.util.List;

@Service
public class CustomerDataService {

    private final CustomerDataRepository customerDataRepository;

    public CustomerDataService(CustomerDataRepository customerDataRepository){
        this.customerDataRepository = customerDataRepository;
    }

    public List<CustomerData> getAll(){
        return customerDataRepository.findAll();
    }

    public CustomerData save(CustomerData customerData){
        return customerDataRepository.save(customerData);
    }
}
