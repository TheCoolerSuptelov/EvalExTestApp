package com.example.demo.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BaseEngineUseCaseImplTest {

	@Test
	void basicExample() {
		 new BaseEngineUseCaseImpl().basicExample();

	}

	@Test
	void sumExample() {
		var res = new BaseEngineUseCaseImpl().sumExample();
		var degub = 1;
	}
}