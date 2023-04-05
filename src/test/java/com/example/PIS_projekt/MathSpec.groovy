package com.example.PIS_projekt

import spock.lang.Specification



class MathSpec extends Specification {

    def "addition of two numbers"() {
        given:
        def a = 2
        def b = 3

        when:
        def result = a + b

        then:
        result == 5
    }
}
