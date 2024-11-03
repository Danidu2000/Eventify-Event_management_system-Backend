package edu.icet.controller;

import edu.icet.dto.Payment;
import edu.icet.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@CrossOrigin
public class PaymentController {
    @Autowired
    final PaymentService service;
    @GetMapping("/get-all")
    public List<Payment> getAll(){
        return service.getAll();
    }
    @PostMapping("/add-payment")
    public void addPayment(@RequestBody Payment payment){
        service.add(payment);
    }
    @PutMapping("/update-payment")
    public void updatePayment(@RequestBody Payment payment){
        service.update(payment);
    }
    @DeleteMapping("/deleteById-by-id/{id}")
    public void deletePayment(@PathVariable Integer id){
        service.deleteById(id);
    }
    @GetMapping("/search-by-id/{id}")
    public Payment searchUserById(@PathVariable Integer id){
        return service.searchById(id);
    }
}
