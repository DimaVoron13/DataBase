package DataBase.hogwards.controller;

import DataBase.hogwards.model.Faculty;
import DataBase.hogwards.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    public final FacultyService servFaculty;

    public FacultyController(FacultyService servFaculty) {
        this.servFaculty = servFaculty;
    }

    @GetMapping("{id}")
    public Faculty findfaculty(@PathVariable Long id) {
        return servFaculty.findFaculty(id);
    }

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return servFaculty.addFaculty(faculty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> editFaculty(@PathVariable Long id, @RequestParam String name, @RequestParam String color) {
        Faculty faculty = servFaculty.editFaculty(id, name, color);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        servFaculty.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> facultyByColor(@RequestParam(required = false) String color) {
        if (color == null || color.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(servFaculty.facultiesByColor(color));
    }
}
