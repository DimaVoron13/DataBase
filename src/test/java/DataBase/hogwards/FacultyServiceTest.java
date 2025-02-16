package DataBase.hogwards;

import DataBase.hogwards.model.Faculty;
import DataBase.hogwards.repository.FacultyRepository;
import DataBase.hogwards.service.FacultyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FacultyServiceTest {
    @Mock
    private FacultyRepository facultyRepository;
    @InjectMocks
    private FacultyService facultyService;

    @Test
    public void findFaculty() {
        Faculty expected = new Faculty();
        expected.setId(1L);
        when(facultyRepository.findById(1L)).thenReturn(Optional.of(expected));
        Faculty actual = facultyService.findFaculty(1L);
        assertNotNull(actual);
        assertEquals(actual, expected);
        verify(facultyRepository, times(1)).findById(1L);
    }

    @Test
    public void addFaculty() {
        Faculty expected = new Faculty();
        expected.setId(1L);
        when(facultyRepository.save(expected)).thenReturn((expected));
        Faculty actual = facultyService.addFaculty(expected);
        assertNotNull(actual);
        assertEquals(actual, expected);
    }
}
