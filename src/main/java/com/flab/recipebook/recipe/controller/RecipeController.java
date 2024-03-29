package com.flab.recipebook.recipe.controller;

import com.flab.recipebook.common.dto.ResponseResult;
import com.flab.recipebook.recipe.dto.SaveRecipeDto;
import com.flab.recipebook.recipe.dto.SearchRecipeDto;
import com.flab.recipebook.recipe.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/recipe/save")
    public ResponseEntity<ResponseResult> saveRecipe(@RequestBody SaveRecipeDto saveRecipeDto) {
        recipeService.saveRecipe(saveRecipeDto);
        return new ResponseEntity(new ResponseResult(), HttpStatus.CREATED);
    }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<ResponseResult> findById(@PathVariable Long recipeId) {
        return new ResponseEntity<>(new ResponseResult(recipeService.findById(recipeId)), HttpStatus.OK);
    }

    @GetMapping("/recipe/search")
    public ResponseEntity<ResponseResult> findByKeyword(@RequestBody SearchRecipeDto searchRecipeDto) {
        return new ResponseEntity<>(new ResponseResult(recipeService.findByKeyword(searchRecipeDto)), HttpStatus.OK);
    }

    @GetMapping("/recipe/search/all")
    public ResponseEntity<ResponseResult> findAll() {
        return new ResponseEntity<>(new ResponseResult(recipeService.findAll()), HttpStatus.OK);
    }
}
