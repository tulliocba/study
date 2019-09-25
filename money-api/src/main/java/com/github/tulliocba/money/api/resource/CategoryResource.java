package com.github.tulliocba.money.api.resource;

import com.github.tulliocba.money.api.event.CreatedResourceEvent;
import com.github.tulliocba.money.api.model.Category;
import com.github.tulliocba.money.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController // --> it is a rest controller
@RequestMapping("/categories") // --> with your requests mapped to categories path
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping // --> it is a get request
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
    public List<Category> list(){
        return categoryRepository.findAll();
    }

    @PostMapping // --> it is a post request
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
    public ResponseEntity<Category> create(/* --> it is the object sent to us */ @Valid @RequestBody Category category,
                                                                      HttpServletResponse response){
        Category savedCategory = categoryRepository.save(category);
        publisher.publishEvent(new CreatedResourceEvent(this, response, savedCategory.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @GetMapping("/{categoryId}") // The path variable name should be equals variable name on method
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
    public ResponseEntity<?> findById(/*When the variable is sent through the URI or path, we use --> */@PathVariable Integer categoryId){
        Optional<Category> category = Optional.ofNullable(categoryRepository.findOne(categoryId));
        return  category.isPresent() ? ResponseEntity.ok(category.get()) : ResponseEntity.notFound().build();
    }

}
