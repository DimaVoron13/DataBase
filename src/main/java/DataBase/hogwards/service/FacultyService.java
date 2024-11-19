package DataBase.hogwards.service;

import DataBase.hogwards.exceptions.FacultyNotFoundException;
import DataBase.hogwards.model.Faculty;
import DataBase.hogwards.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(Long facultyId) {
        return facultyRepository.findById(facultyId).orElseThrow(() -> new FacultyNotFoundException());
    }

    public Faculty editFaculty(Long id, String name, String color) {
        Faculty faculty = facultyRepository.findById(id).get();
        faculty.setName(name);
        faculty.setColor(color);
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long facultyId) {
        facultyRepository.deleteById(facultyId);
    }

    public Collection<Faculty> facultiesByColor(String color) {
        Set<Faculty> res = facultyRepository.findByColor(color);
        return Collections.unmodifiableCollection(res);
    }
}
