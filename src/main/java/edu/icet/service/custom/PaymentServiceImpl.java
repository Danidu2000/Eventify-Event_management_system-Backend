package edu.icet.service.custom;

import edu.icet.dto.Payment;
import edu.icet.entity.PaymentEntity;
import edu.icet.repository.PaymentRepository;
import edu.icet.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;
    private final ModelMapper mapper;
    @Override
    public void add(Payment payment) {
        repository.save(mapper.map(payment, PaymentEntity.class));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Payment> getAll() {
        ArrayList<Payment> paymentArrayList = new ArrayList<>();
        repository.findAll().forEach(paymentEntity -> {
            paymentArrayList.add(mapper.map(paymentEntity, Payment.class));
        });
        return paymentArrayList;
    }

    @Override
    public void update(Payment payment) {
        repository.save(mapper.map(payment, PaymentEntity.class));
    }

    @Override
    public Payment searchById(Integer id) {
        return mapper.map(repository.findById(id), Payment.class);
    }
}
