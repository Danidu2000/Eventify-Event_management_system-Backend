package edu.icet.service.custom;

import edu.icet.dto.Review;
import edu.icet.entity.ReviewEntity;
import edu.icet.repository.ReviewRepository;
import edu.icet.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;
    private final ModelMapper mapper;
    @Override
    public void add(Review review) {
        repository.save(mapper.map(review, ReviewEntity.class));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Review> getAll() {
        List<Review> reviewArrayList = new ArrayList<>();
        repository.findAll().forEach(reviewEntity -> {
            reviewArrayList.add(mapper.map(reviewEntity, Review.class));
        });
        return reviewArrayList;
    }

    @Override
    public void update(Review review) {
        repository.save(mapper.map(review, ReviewEntity.class));
    }

    @Override
    public Review searchById(Integer id) {
        return mapper.map(repository.findById(id), Review.class);
    }
}
