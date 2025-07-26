package dev.kylelohrberg.databridge.repository;

import dev.kylelohrberg.databridge.entity.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDataRepository extends JpaRepository<CustomerData, Long> {
}
