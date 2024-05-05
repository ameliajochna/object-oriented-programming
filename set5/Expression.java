abstract class Expression {
    public abstract int evaluate();
    public abstract String toString();
    public void setVariable(String setName, int setValue){};
}

class Const extends Expression {
    private int value;

    public Const(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

class Variable extends Expression {
    private String name;
    private int value;

    public Variable(String name) {
        this.name = name;
        this.value = 0;
    }

    @Override
    public void setVariable(String setName, int setValue){
        if(this.name == setName){
            value = setValue;
        }
    };

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Add extends Expression {
    private Expression leftExp;
    private Expression rightExp;

    public Add(Expression left, Expression right) {
        this.leftExp = left;
        this.rightExp = right;
    }

    @Override
    public void setVariable(String setName, int setValue){
        leftExp.setVariable(setName, setValue);
        rightExp.setVariable(setName, setValue);
    };

    @Override
    public int evaluate() {
        return leftExp.evaluate() + rightExp.evaluate();
    }

    @Override
    public String toString() {
        return "(" + leftExp.toString() + " + " + rightExp.toString() + ")";
    }
}

class Subtract extends Expression {
    private Expression leftExp;
    private Expression rightExp;

    public Subtract(Expression left, Expression right) {
        this.leftExp = left;
        this.rightExp = right;
    }

    @Override
    public void setVariable(String setName, int setValue){
        leftExp.setVariable(setName, setValue);
        rightExp.setVariable(setName, setValue);
    };

    @Override
    public int evaluate() {
        return leftExp.evaluate() - rightExp.evaluate();
    }

    @Override
    public String toString() {
        return "(" + leftExp.toString() + " - " + rightExp.toString() + ")";
    }
}

class Multiply extends Expression {
    private Expression leftExp;
    private Expression rightExp;

    public Multiply(Expression left, Expression right) {
        this.leftExp = left;
        this.rightExp = right;
    }

    @Override
    public void setVariable(String setName, int setValue){
        leftExp.setVariable(setName, setValue);
        rightExp.setVariable(setName, setValue);
    };

    @Override
    public int evaluate() {
        return leftExp.evaluate() * rightExp.evaluate();
    }

    @Override
    public String toString() {
        return "(" + leftExp.toString() + " * " + rightExp.toString() + ")";
    }
}

class IntegerDivide extends Expression {
    private Expression leftExp;
    private Expression rightExp;

    public IntegerDivide(Expression left, Expression right) {
        this.leftExp = left;
        this.rightExp = right;
    }

    @Override
    public void setVariable(String setName, int setValue){
        leftExp.setVariable(setName, setValue);
        rightExp.setVariable(setName, setValue);
    };

    @Override
    public int evaluate() {
        return leftExp.evaluate() / rightExp.evaluate();
    }

    @Override
    public String toString() {
        return "(" + leftExp.toString() + " / " + rightExp.toString() + ")";
    }
}

