package com.example.LAB2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatServiceTest {
    @Mock
    private CatsRepository repository;
    private AutoCloseable openMocks;
    private CatService catService;
    @BeforeEach
    public void init(){
        openMocks = MockitoAnnotations.openMocks(this);
        catService = new CatService(repository);
    }
    @AfterEach
    public void tearDown() throws Exception {
        openMocks.close();
    }
    @Test
    public void findFinds(){
        String name = "janek";
        Cat cap = new Cat(name, 20);
        Mockito.when(repository.findByName(name)).thenReturn(cap);

        Cat result = catService.getCatByName(name);
        assertEquals(cap, result);
    }
    @Test
    public void saveSaves(){
        String name = "janek";
        Integer age = 4;
        Cat cat = new Cat(name, age);
        ArgumentCaptor<Cat> captor = ArgumentCaptor.forClass(Cat.class);
        Mockito.when(repository.save(captor.capture())).thenReturn(cat);

        catService.addCat(cat);
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
        Cat catFromSaveCall = captor.getValue();
        assertEquals(cat, catFromSaveCall);
    }
}
