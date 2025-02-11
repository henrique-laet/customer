package com.laet.customer.service;

import com.laet.customer.dto.AddressDto;
import com.laet.customer.entity.Address;
import com.laet.customer.entity.Customer;
import com.laet.customer.exception.AddressNotFoundException;
import com.laet.customer.repository.AddressRepository;
import com.laet.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Endereço não encontrado com ID: " + id));
    }

    public Address createAddress(AddressDto addressDto) {

        Optional<Customer> customer = customerRepository.findById(addressDto.getCustomerId());
        if (customer.isPresent()) {
            Address address = new Address();

            address.setRoad(addressDto.getRoad());
            address.setNumber(addressDto.getNumber());
            address.setNeighborhood(addressDto.getNeighborhood());
            address.setCity(addressDto.getCity());
            address.setState(addressDto.getState());
            address.setCep(addressDto.getCep());
            address.setCustomer(customer.get());
            address.setDh_incl(LocalDateTime.now());

            return addressRepository.save(address);
        } else {
            throw new AddressNotFoundException(addressDto.getCustomerId());
        }
    }

    public Address updateAddress(Long id, AddressDto addressDto) {
        if (!addressRepository.existsById(id)) {
            throw new AddressNotFoundException("Não foi possivel fazer a atualizacao com o ID: " + id);
        }

        Address address = new Address();

        address.setId(id);
        address.setRoad(addressDto.getRoad());
        address.setNumber(addressDto.getNumber());
        address.setNeighborhood(addressDto.getNeighborhood());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setCep(addressDto.getCep());

        return addressRepository.save(address);
    }

    public boolean deleteAddress(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new AddressNotFoundException("Não foi possivel deletar o endereço com ID: " + id);
        }
        addressRepository.deleteById(id);
        return true;
    }

}

