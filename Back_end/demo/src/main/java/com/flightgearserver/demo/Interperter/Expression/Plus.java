package com.flightgearserver.demo.Interperter.Expression;

public class Plus extends BinaryExpression {

	public Plus(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public double calculate() {
		return left.calculate()+right.calculate();
	}

}
