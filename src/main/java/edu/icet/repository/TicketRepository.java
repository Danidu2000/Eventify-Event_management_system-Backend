package edu.icet.repository;

import edu.icet.entity.EventEntity;
import edu.icet.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
    List<TicketEntity> findByOrganizerId(Integer id);

    List<TicketEntity> findByEventId(Integer id);
}
