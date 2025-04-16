package com.example.demo.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BaseEngineUseCaseImplTest {

	@Test
	void basicExample() {
		var res = new BaseEngineUseCaseImpl().basicExample();

		assertEquals(0, new BigDecimal("6").compareTo(res.getNumberValue()));
	}

	@Test
	void sumExample() {
		var res = new BaseEngineUseCaseImpl().sumExample();

		assertEquals(15, res.getNumberValue().intValueExact());
	}


	@Test
	void mapsExample() {
		var res = new BaseEngineUseCaseImpl().maps();

		assertEquals("110", res.getNumberValue().toPlainString());
	}


	@Test
	void mapsSimple(){
		var res = new BaseEngineUseCaseImpl().mapsSimple();

		assertEquals("110", res.getNumberValue().toPlainString());
	}

	@Test
	void mapsSimpleAnotherTry(){
		var res = new BaseEngineUseCaseImpl().mapsSimpleAnotherTry();

		assertEquals("110", res.getNumberValue().toPlainString());
	}
}