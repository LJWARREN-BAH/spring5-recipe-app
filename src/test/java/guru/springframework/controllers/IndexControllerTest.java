package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.h2.index.Index;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalMatchers.eq;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class IndexControllerTest {
    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        controller = new IndexController(recipeService);
    }

    @Test
    void getIndexPage() throws Exception {

        String viewName = controller.getIndexPage(model);
        Set anySet = new HashSet<String>();
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(("recipes"), anySet);
    }
}