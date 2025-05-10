package demo.lab4_20206303.repository;
import demo.lab4_20206303.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
}

