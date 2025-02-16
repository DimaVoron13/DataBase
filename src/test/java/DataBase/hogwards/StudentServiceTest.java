package DataBase.hogwards;

import DataBase.hogwards.model.Student;
import DataBase.hogwards.repository.StudentRepository;
import DataBase.hogwards.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    public void findStudent() {
        Student expected = new Student();
        expected.setId(1L);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(expected));
        Student actual = studentService.findStudent(1L);
        assertNotNull(actual);
        assertEquals(actual, expected);
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    public void addStudent() {
        Student expected = new Student();
        expected.setId(1L);
        when(studentRepository.save(expected)).thenReturn(expected);
        Student actual = studentService.addStudent(expected);
        assertNotNull(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void editStudent() {
        Student expected = new Student();
        expected.setId(1L);
        when(studentRepository.save(expected)).thenReturn(expected);
        Student actual = studentService.editStudent(expected);
        assertEquals(actual, expected);
    }
}
