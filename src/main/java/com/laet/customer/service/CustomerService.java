package com.laet.customer.service;

import com.laet.customer.entity.Address;
import com.laet.customer.entity.Customer;
import com.laet.customer.repository.AddressRepository;
import com.laet.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getAllById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        customer.setDh_incl(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        if(customerRepository.existsById(id)) {
            customer.setId(id);
            customerRepository.save(customer);
            return customer;
        } else {
            return null;
        }
    }

    public boolean deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
