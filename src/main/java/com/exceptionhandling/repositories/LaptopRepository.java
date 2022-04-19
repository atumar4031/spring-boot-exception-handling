package com.exceptionhandling.repositories;

import com.exceptionhandling.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository  extends JpaRepository<Laptop, Long> {
}
