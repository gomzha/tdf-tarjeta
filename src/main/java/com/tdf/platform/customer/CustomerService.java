package com.tdf.platform.customer;


import com.tdf.platform.exception.DuplicateResourceException;
import com.tdf.platform.exception.RequestValidationException;
import com.tdf.platform.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;
    private final CustomerDTOMapper customerDTOMapper;

    public CustomerService(CustomerDAO customerDAO, CustomerDTOMapper mapper, CustomerDTOMapper customerDTOMapper) {
        this.customerDAO = customerDAO;
        this.customerDTOMapper = customerDTOMapper;
    }


    public List<CustomerDTO> getAllCustomers() {
        return customerDAO.selectAllCustomers()
                .stream()
                .map(customerDTOMapper)
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomer(Long id) {
        return customerDAO.selectCustomerById(id)
                .map(customerDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "customer with id [%s] not found".formatted(id)
                ));
    }


    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        // check if email exists
        String email = customerRegistrationRequest.email();
        if (customerDAO.existsCustomerWithEmail(email)) {
            throw new DuplicateResourceException("email already taken");
        }

        // add
        Customer customer = new Customer(
                customerRegistrationRequest.name(),
                customerRegistrationRequest.lastName(),
                customerRegistrationRequest.email(),
                customerRegistrationRequest.birthDate()
        );

        customerDAO.insertCustomer(customer);
    }

    public void deleteCustomerById(Long customerId) {
        checkIfCustomerExistsOrThrow(customerId);
        customerDAO.deleteCustomerById(customerId);
    }

    private void checkIfCustomerExistsOrThrow(Long customerId) {
        if (!customerDAO.existsCustomerById(customerId)) {
            throw new ResourceNotFoundException("customer with id [%s] not found".formatted(customerId));
        }
    }

    public void updateCustomer(Long customerId, CustomerUpdateRequest updateRequest) {
        Customer customer = customerDAO.selectCustomerById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("customer with id [%s] not found".formatted(customerId)));

        boolean changes = false;

        if (updateRequest.name() != null && !updateRequest.name().equals(customer.getName())) {
            customer.setName(updateRequest.name());
            changes = true;
        }

        if (updateRequest.lastName() != null && !updateRequest.lastName().equals(customer.getLastName())) {
            customer.setLastName(updateRequest.lastName());
            changes = true;
        }

        if (!changes) {
            throw new RequestValidationException("no data changes found");
        }

        customerDAO.updateCustomer(customer);
    }
}
