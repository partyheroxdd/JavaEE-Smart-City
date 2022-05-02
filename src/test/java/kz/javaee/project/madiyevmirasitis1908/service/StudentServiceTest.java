package kz.javaee.project.madiyevmirasitis1908.service;

import kz.javaee.project.madiyevmirasitis1908.model.StudentPlace;
import kz.javaee.project.madiyevmirasitis1908.repository.StudentPlaceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class StudentServiceTest {
    @Mock
    StudentPlaceRepository studentPlaceRepository;
    @InjectMocks
    StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() {
        when(studentPlaceRepository.getAll()).thenReturn(Arrays.<StudentPlace>asList(new StudentPlace(Long.valueOf(1), "name", "category", "address", "contactInfo")));

        List<StudentPlace> result = studentService.getAll();
        Assertions.assertEquals(Arrays.<StudentPlace>asList(new StudentPlace(Long.valueOf(1), "name", "category", "address", "contactInfo")), result);
    }

    @Test
    void testGetStudentPlaceById() {
        when(studentPlaceRepository.findById(anyLong(), any())).thenReturn(new StudentPlace(Long.valueOf(1), "name", "category", "address", "contactInfo"));

        StudentPlace result = studentService.getStudentPlaceById(Long.valueOf(1));
        Assertions.assertEquals(new StudentPlace(Long.valueOf(1), "name", "category", "address", "contactInfo"), result);
    }

    @Test
    void testCreateNewStudentPlace() {
        studentService.createNewStudentPlace(new StudentPlace(Long.valueOf(1), "name", "category", "address", "contactInfo"));
    }

    @Test
    void testUpdateStudentPlaceAddress() {
        when(studentPlaceRepository.findById(anyLong(), any())).thenReturn(new StudentPlace(Long.valueOf(1), "name", "category", "address", "contactInfo"));

        studentService.updateStudentPlaceAddress(Long.valueOf(1), "address");
    }

    @Test
    void testDeleteStudentPlaceById() {
        when(studentPlaceRepository.findById(anyLong(), any())).thenReturn(new StudentPlace(Long.valueOf(1), "name", "category", "address", "contactInfo"));

        studentService.deleteStudentPlaceById(Long.valueOf(1));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme