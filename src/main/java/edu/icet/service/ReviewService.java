package edu.icet.service;

import edu.icet.dto.Review;

import java.util.List;

public interface ReviewService extends CrudService<Review> {
    List<Review> getReviewsByEventId(Integer id);

    List<Review> getReviewsByUserId(Integer id);
}
