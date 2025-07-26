package dev.kylelohrberg.databridge.service;

import dev.kylelohrberg.databridge.entity.CustomerData;
import org.springframework.stereotype.Service;
import dev.kylelohrberg.databridge.repository.CustomerDataRepository;

import java.util.List;
import java.util.Optional;

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

    public Optional<CustomerData> getById(Long id){
        return customerDataRepository.findById(id);
    }

    public Optional<CustomerData> update(Long id, CustomerData updatedData){
        return customerDataRepository.findById(id).map(existing -> {
            existing.setFullName(updatedData.getFullName());
            existing.setEmail(updatedData.getEmail());
            existing.setSourceSystem(updatedData.getSourceSystem());
            existing.setImportStatus(updatedData.getImportStatus());
            return customerDataRepository.save(existing);
        });
    }

    public boolean delete(Long id){
        if(customerDataRepository.existsById(id)){
            customerDataRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
