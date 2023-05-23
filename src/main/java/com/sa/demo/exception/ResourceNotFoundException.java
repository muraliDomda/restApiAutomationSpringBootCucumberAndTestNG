package com.sa.demo.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
@Data
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

    public String resourceName;
    public String filedNmae;
    public Object filedValue;

}
