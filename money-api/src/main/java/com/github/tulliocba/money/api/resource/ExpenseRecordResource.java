package com.github.tulliocba.money.api.resource;

import com.github.tulliocba.money.api.event.CreatedResourceEvent;
import com.github.tulliocba.money.api.exceptionhandler.MoneyApiExceptionHandler;
import com.github.tulliocba.money.api.model.ExpenseRecord;
import com.github.tulliocba.money.api.repository.expense_record.ExpenseRecordRepository;
import com.github.tulliocba.money.api.repository.filter.ExpenseRecordFilter;
import com.github.tulliocba.money.api.repository.projection.ExpenseRecordProjection;
import com.github.tulliocba.money.api.services.ExpenseRecordService;
import com.github.tulliocba.money.api.services.exception.NonExistentPersonOrNotEnabledException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseRecordResource {

    @Autowired
    private ExpenseRecordRepository expenseRecordRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private ExpenseRecordService expenseRecordService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') && #oauth2.hasScope('read')")
    public List<ExpenseRecord> list(){
        return expenseRecordRepository.findAll();
    }

    @GetMapping("/search")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') && #oauth2.hasScope('read')")
    public Page<ExpenseRecord> findBy(ExpenseRecordFilter expenseRecordFilter, Pageable pageable){
        return expenseRecordRepository.findExpenseRecordBy(expenseRecordFilter, pageable);
    }

    @GetMapping(value = "/search", params = "digest")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') && #oauth2.hasScope('read')")
    public Page<ExpenseRecordProjection> digest(ExpenseRecordFilter expenseRecordFilter, Pageable pageable){
        return expenseRecordRepository.digest(expenseRecordFilter, pageable);
    }

    @GetMapping("/{expenseId}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') && #oauth2.hasScope('read')")
    public ResponseEntity<?> findExpenseById(@PathVariable Integer expenseId){
        Optional<ExpenseRecord> optionalExpense = Optional.ofNullable(expenseRecordRepository.findOne(expenseId));
        return optionalExpense.isPresent() ? ResponseEntity.ok(optionalExpense.get()) : ResponseEntity.noContent().build();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO') && #oauth2.hasScope('write')")
    public ResponseEntity<ExpenseRecord> create(@Valid @RequestBody ExpenseRecord expenseRecord, HttpServletResponse response){
        ExpenseRecord savedExpense = expenseRecordService.saveExpenseRecord(expenseRecord);
        publisher.publishEvent(new CreatedResourceEvent(this, response, savedExpense.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedExpense);
    }

    @PutMapping("/{expenseId}")
    @PreAuthorize("hasAnyAuthority('ROLE_CADASTRAR_LANCAMENTO') && #oauth2.hasScope('write')")
    public ResponseEntity<ExpenseRecord> update(@Valid @RequestBody ExpenseRecord expenseRecord,@PathVariable Integer expenseId){
        ExpenseRecord expenseUpdated = expenseRecordService.updateExpense(expenseId, expenseRecord);
        return ResponseEntity.ok(expenseUpdated);
    }


    @DeleteMapping("/{expenseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_REMOVER_LANCAMENTO') && #oauth2.hasScope('write')")
    public void delete(@PathVariable Integer expenseId){
        expenseRecordRepository.delete(expenseId);
    }

    @ExceptionHandler({NonExistentPersonOrNotEnabledException.class})
    public ResponseEntity<Object> handleNonExistentPersonOrNotEnabledException(NonExistentPersonOrNotEnabledException ex){
        String userMessage = messageSource.getMessage("resource.non-existent.or.inactive.person", null, LocaleContextHolder.getLocale());
        String developerMessage = ex.toString();

        return ResponseEntity.badRequest().body(Arrays.asList(new MoneyApiExceptionHandler.ApiError(userMessage, developerMessage)));
    }




}
