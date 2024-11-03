package edu.icet.controller;

import edu.icet.dto.Review;
import edu.icet.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
@CrossOrigin
public class ReviewController {
    @Autowired
    final ReviewService service;
    @GetMapping("/get-all")
    public List<Review> getAll(){
        return service.getAll();
    }
    @PostMapping("/add-review")
    public void addReview(@RequestBody Review review){
        service.add(review);
    }
    @PutMapping("/update-review")
    public void updateReview(@RequestBody Review review){
        service.update(review);
    }
    @DeleteMapping("/deleteById-by-id/{id}")
    public void deletePayment(@PathVariable Integer id){
        service.deleteById(id);
    }
    @GetMapping("/search-by-id/{id}")
    public Review searchUserById(@PathVariable Integer id){
        return service.searchById(id);
    }
}
