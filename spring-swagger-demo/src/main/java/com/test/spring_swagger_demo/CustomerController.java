package com.test.spring_swagger_demo;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer API", description = "Operations related to customer details")
public class CustomerController {

    @GetMapping("/by-id/{custId}")
    @Operation(summary = "Get customer by ID")
    public Customer getCustomerById(@PathVariable String custId) {
    	System.out.println("getCustomerById");
        return new Customer(custId, "John Doe", "1234567890");
    }

    @GetMapping("/by-phone")
    @Operation(summary = "Get customer by Phone Number")
    public Customer getCustomerByPhone(@RequestParam String phone) {
    	System.out.println("getCustomerByPhone");
        return new Customer("CUST123", "Jane Smith", phone);
    }
}
