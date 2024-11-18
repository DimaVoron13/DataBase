package DataBase.hogwards.service;

import DataBase.hogwards.exceptions.StudentNotFoundException;
import DataBase.hogwards.model.Student;
import DataBase.hogwards.repository.StudentRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException());
    }

    public Student addStudent(Student temp) {
        return studentRepository.save(temp);
    }

    public Student editStudent(Student temp) {
        return studentRepository.save(temp);
    }

    public void deleteSudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> studentsByAge(int age) {
        Set<Student> result = studentRepository.findByAge(age);
        return Collections.unmodifiableCollection(result);
    }
}
