package com.pchudzik.springmock.samples.springboot2.spock;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    private final TwoRepository twoRepository;
    private final AddOne addOne;

    public MyService(TwoRepository twoRepository, AddOne addOne) {
        this.twoRepository = twoRepository;
        this.addOne = addOne;
    }

    public int calculate(int a) {
        return addOne.addOne(a) + twoRepository.getTwo();
    }
}
