package com.pchudzik.springmock.samples.springboot2.spock;

import org.springframework.stereotype.Service;

@Service
public class AddOne {
    public int addOne(int a) {
        return a + 1;
    }
}
