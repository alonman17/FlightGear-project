package com.flightgearserver.demo.Interperter.Expression;

public class Minus extends BinaryExpression {

	public Minus(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public double calculate() {
		return left.calculate()-right.calculate();
	}

}
