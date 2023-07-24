package controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("https://localhost:4200")
@RestController
@RequestMapping("/api/customers")
public class CustomersController {
}
