package com.example.demo.calculator;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class BaseEngineUseCaseImpl {


	public EvaluationValue basicExample() {
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

	public EvaluationValue sumExample() {
		Expression expression = new Expression("sum(list)");
		EvaluationValue res = null;
		try {
			res = expression.
							with("list", List.of(1, 2, 3, 4, 5)).evaluate();
		} catch (EvaluationException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return res;
	}


	public EvaluationValue maps() {
		Expression expression = new Expression("data.current.oneZeroOne.H12 + data.current_minus_1.oneZeroOne.H12");


		EvaluationValue res = null;
		try {
			res = expression
							.with("data",
											Map.of(
															"current", Map.of("oneZeroOne", Map.of("H12", 10)),
															"current_minus_1", Map.of("oneZeroOne", Map.of("H12", 100))

											)

							)
							.evaluate();
		} catch (EvaluationException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		return res;
	}

	public EvaluationValue mapsSimple() {
		Expression expression = new Expression("data.current._101 + data.current_minus_1._101");

		EvaluationValue res = null;
		try {
			res = expression
							.with("data",
											Map.of(
															"current", Map.of("_101", 10),
															"current_minus_1", Map.of("_101", 100)

											)

							)
							.evaluate();
		} catch (EvaluationException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		return res;
	}


	public EvaluationValue mapsSimpleAnotherTry() {
		Expression expression = new Expression("data.current.\"101\" + data.current_minus_1.\"101\"");

		EvaluationValue res = null;
		try {
			res = expression
							.with("data",
											Map.of(
															"current", Map.of("\"101\"", 10),
															"current_minus_1", Map.of("\"101\"", 100)

											)

							)
							.evaluate();
		} catch (EvaluationException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		return res;
	}


}
