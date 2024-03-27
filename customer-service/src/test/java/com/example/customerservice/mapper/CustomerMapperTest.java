package com.example.customerservice.mapper;

import com.example.customerservice.dto.CustomerDTO;
import com.example.customerservice.entities.Customer;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {
    CustomerMapper underTest=new CustomerMapper();
    //comment
    @Test
    public void shouldMapCustomerToCustomerDTO() {
        Customer givenCustomer = Customer.builder().id(1L).lastName("ayou").firstName("khatouri").email("ayoub@gmail.com").build();
        CustomerDTO expected = CustomerDTO.builder().id(1L).lastName("ayoub").firstName("khatouri").email("ayoub@gmail.com").build();

        CustomerDTO result = underTest.fromCustomer(givenCustomer);
        AssertionsForClassTypes.assertThat(result ).isNotNull();
        AssertionsForClassTypes.assertThat(expected).usingRecursiveComparison().isEqualTo(result);
    }

    @Test
    public void shouldMapCustomerDTOToCustomer() {
        CustomerDTO givenCustomerDTO = CustomerDTO.builder()
                .id(1L).lastName("ayoub").firstName("mohamed").email("med@gmail.com").build();
        Customer expected = Customer.builder()
                .id(1L).lastName("ayoub").firstName("mohamed").email("med@gmail.com").build();
        Customer result = underTest.fromCustomerDTO(givenCustomerDTO);

        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(expected).usingRecursiveComparison().isEqualTo(result);
    }

    @Test
    public void shouldMapListOfCustomersToListOfCustomers() {
        List<Customer> givenCustomers = List.of(
                Customer.builder().id(1L).lastName("ayoub").firstName("mohamed").email("med@gmail.com").build(),
                Customer.builder().id(2L).lastName("imane").firstName("imane").email("imane@gmail.com").build(),
                Customer.builder().id(3L).lastName("yassine").firstName("yassine").email("yassine@gmail.com").build()
        );

        List<CustomerDTO> expected = List.of(
                CustomerDTO.builder().id(1L).lastName("ayoub").firstName("mohamed").email("med@gmail.com").build(),
                CustomerDTO.builder().id(2L).lastName("imane").firstName("imane").email("imane@gmail.com").build(),
                CustomerDTO.builder().id(3L).lastName("yassine").firstName("yassine").email("yassine@gmail.com").build()
        );
        List<CustomerDTO> result = underTest.fromListCustomers(givenCustomers);
        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(expected) .usingRecursiveComparison().isEqualTo(result);
    }

    @Test
    public void shouldNotMapNullCustomerToCustomerDTO(){
    Customer givenCustomer = null;
    AssertionsForClassTypes.assertThatThrownBy(()->underTest.fromCustomer(givenCustomer))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
