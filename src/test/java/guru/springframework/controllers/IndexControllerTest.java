package guru.springframework.controllers;

<<<<<<< HEAD
import guru.springframework.services.RecipeService;
import org.h2.index.Index;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
=======
import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
>>>>>>> upstream/mockiot-argument-capture
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalMatchers.eq;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class IndexControllerTest {
=======
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
/**
 * Created by jt on 6/17/17.
 */
public class IndexControllerTest {

>>>>>>> upstream/mockiot-argument-capture
    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

<<<<<<< HEAD
    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
=======
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

>>>>>>> upstream/mockiot-argument-capture
        controller = new IndexController(recipeService);
    }

    @Test
<<<<<<< HEAD
    void getIndexPage() throws Exception {

        String viewName = controller.getIndexPage(model);
        Set anySet = new HashSet<String>();
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(("recipes"), anySet);
    }
=======
    public void getIndexPage() throws Exception {

        //given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        recipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String viewName = controller.getIndexPage(model);


        //then
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }

>>>>>>> upstream/mockiot-argument-capture
}