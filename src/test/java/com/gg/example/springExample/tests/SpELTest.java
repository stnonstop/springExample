package com.gg.example.springExample.tests;

import com.gg.example.springExample.model.Vet;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


/**
 * User: adurmaz
 * Date: 5/10/13
 * Time: 11:14 AM
 */
public class SpELTest {


    @Test
    public void testSpEL(){
        Vet vet = new Vet();
        vet.setFirstName("Aziz");

        System.out.println("Before : " + vet);

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("firstName");

        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext(vet);

        String firstName = (String)expression.getValue(standardEvaluationContext);

        Expression expression2 = parser.parseExpression("lastName");
        expression2.setValue(standardEvaluationContext, "DURMAZ");

        System.out.println(firstName);
        System.out.println("after :"+vet);

        Expression expression1 = parser.parseExpression("new com.gg.example.springExample.model.Vet()");
        System.out.println("New Vet :" + expression1.getValue());
    }
}
