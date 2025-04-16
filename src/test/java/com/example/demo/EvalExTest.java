package com.example.demo;


import com.ezylang.evalex.Expression;
import com.ezylang.evalex.parser.ParseException;
import com.ezylang.evalex.parser.Tokenizer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EvalExTest {


	@Test
	void token(){
		Expression expression = new Expression("data.101");
		var configuration = expression.getConfiguration();

		Tokenizer tokenizer = new Tokenizer(expression.getExpressionString(), configuration);

		try {
			var res = tokenizer.parse();
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		var qq = 1;
	}


}
