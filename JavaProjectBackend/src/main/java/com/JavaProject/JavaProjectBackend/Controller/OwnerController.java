package com.JavaProject.JavaProjectBackend.Controller;

import com.JavaProject.JavaProjectBackend.DTO.OwnerDto;
import com.JavaProject.JavaProjectBackend.Service.IOwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class OwnerController {
    private IOwnerService _ownerService;

    public OwnerController(IOwnerService ownerService) {
        _ownerService = ownerService;
    }

    @GetMapping("owner")
    public ResponseEntity<List<OwnerDto>> getAllOwners() {
        List<OwnerDto> owners = _ownerService.getAllOwners();

        return new ResponseEntity<>(owners, HttpStatus.OK);
    }
}
