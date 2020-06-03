package com.example.crowdfunding.repos;

import com.example.crowdfunding.domain.Fund;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FundRepo extends CrudRepository<Fund, Long> {
    List<Fund> findByTag(String tag);
    List<Fund> findByTitle(String title);
}
