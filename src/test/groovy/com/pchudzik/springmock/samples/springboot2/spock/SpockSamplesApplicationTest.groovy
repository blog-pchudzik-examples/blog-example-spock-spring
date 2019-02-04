package com.pchudzik.springmock.samples.springboot2.spock


import org.spockframework.spring.SpringBean
import org.spockframework.spring.SpringSpy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import static com.pchudzik.springmock.samples.springboot2.spock.TwoRepository.TWO

@SpringBootTest(classes = Springboot2Application)
class SpockSamplesApplicationTest extends Specification {
    @SpringBean
    AddOne addOneTranslator = Mock()

    @SpringSpy
    TwoRepository twoRepository

    @Autowired
    MyService myService

    def "should calculate values"() {
        given:
        final inputA = 1
        final translatedA = 10
        final expectedResult = translatedA + TWO
        addOneTranslator.addOne(inputA) >> translatedA

        when:
        final result = myService.calculate(inputA)

        then:
        1 * twoRepository.getTwo()
        result == expectedResult
    }
}
