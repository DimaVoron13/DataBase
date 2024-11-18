package DataBase.hogwards.repository;

import DataBase.hogwards.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Set<Faculty> findByColor(String color);
}
