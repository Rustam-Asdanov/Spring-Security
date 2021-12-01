package com.example_security.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
class DemoApplicationTests {

	Calculator underTest = new Calculator();

	@Test
	void itShouldAddTwoNumbers() {

		// given
		int numberOne = 30;
		int numberTwo = 20;
		// when
		int result = underTest.add(numberOne, numberTwo);

		// then
		int expected = 51;
		assertThat(result).isEqualTo(expected);
	}

	class Calculator{
		int add(int a, int b){
			return a+b;
		}
	}

}
