package org.example.service;

import org.example.dao.Test;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;

@Service
public class TestService {
    public void say() {
        System.out.println("i am doing something");
    }
}
