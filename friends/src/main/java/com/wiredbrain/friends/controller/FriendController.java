package com.wiredbrain.friends.controller;

import com.wiredbrain.friends.exception.ErrorMessage;
import com.wiredbrain.friends.exception.FieldErrorMessage;
import com.wiredbrain.friends.model.Friend;
import com.wiredbrain.friends.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FriendController {
    @Autowired
    private FriendService friendService;

    //@PostMapping("/friend")
    //Friend create(@RequestBody Friend friend) throws ValidationException {
    //    if(friend.getFirstName() != null && friend.getLastName() != null)
    //        return friendService.save(friend);
    //    else
    //        throw new ValidationException("friend cannot be created");
    //}

    @PostMapping("/friend")
    Friend create(@Valid @RequestBody Friend friend){
            return friendService.save(friend);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException ex){
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());
        return fieldErrorMessages;
    }


    /**
     * Class Error Handling
     * send path to this method
     * good path return Entity
     * bad path throw Exception with ExceptionHandler
     * @param
     * @return
     */
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    //@ExceptionHandler(ValidationException.class)
    //ErrorMessage exceptionHandler(ValidationException e){
    //    return new ErrorMessage("400" ,e.getMessage());
    //}

    @GetMapping("/friend")
    Iterable<Friend> read() {
        return friendService.findAll();
    }

    /**
     * Local Error Handling
     * send path to this method
     * good path return Response Entity
     * bad path return Response Entity with  HTTP Status Codes message.
     * @param friend
     * @return
     */
    @PutMapping("/friend")
    ResponseEntity<Friend> update(@RequestBody Friend friend) {
        if(friendService.findById(friend.getId()).isPresent()){
            return new ResponseEntity(friendService.save(friend), HttpStatus.OK);
        }else {
            return new ResponseEntity(friend,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/friend/{id}")
    void delete(@PathVariable Integer id) {
        friendService.deleteById(id);
    }
    @GetMapping("/friend/{id}")
    Optional<Friend> findById(@PathVariable Integer id){
        return friendService.findById(id);
    }

    @GetMapping("/friend/search")
    Iterable<Friend> findByQuery(@RequestParam(value = "first" ,required = false) String firstName , @RequestParam(value = "last", required = false) String lastName){
        if(firstName !=null && lastName != null){
            return friendService.findByFirstNameAndLastName(firstName,lastName);
        }else if(firstName != null){
            return friendService.findByFirstName(firstName);
        }else if (lastName != null){
            return friendService.findByLastName(lastName);
        }else{
            return friendService.findAll();
        }
    }
}
