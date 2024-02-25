package com.basics.amazon.learnJava8;
import java.util.StringJoiner;

public class StringJoinerDemo {
	public static void main(String[] args) {

		StringJoiner joiner = new StringJoiner(",");
		joiner.add("How").add("are").add("you?");

		System.out.println(joiner);

		StringJoiner joiner2 = new StringJoiner(" ", "[", "]");
		joiner2.add("India").add("is a").add("beautiful").add("country!!!");

		System.out.println(joiner2);

		StringJoiner mergedStr = joiner.merge(joiner2);
		System.out.println(mergedStr);
	}

}
