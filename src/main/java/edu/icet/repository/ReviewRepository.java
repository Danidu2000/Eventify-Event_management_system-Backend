package edu.icet.repository;

import edu.icet.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer> {
    List<ReviewEntity> findByUserId(Integer id);

    List<ReviewEntity> findByEventId(Integer id);
}
