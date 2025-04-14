package com.example.demo.calculator;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BaseEngineUseCaseImpl {


	public EvaluationValue basicExample(){
		Expression expression = new Expression("(a + b) * (a - b)");
		EvaluationValue result;
		try {
			result = expression
							.with("a", 3.5)
							.and("b", 2.5)
							.evaluate();
		} catch (EvaluationException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	public EvaluationValue sumExample(){
		Expression expression = new Expression("sum(list)");
		EvaluationValue res = null;
		try {
			 res = expression.
							with("list", List.of(1,2,3,4,5)).evaluate();
		} catch (EvaluationException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return res;
	}


}
