package oopPrinciples;

public class CustomExceptions extends Exception {
        public void NotEnoughMoneyException() throws Exception {
            throw new Exception("No No No. not enough money found");
        }
    }

