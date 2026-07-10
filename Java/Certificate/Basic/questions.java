// This file cannot be compiled. It is provided to enable clean reading of the code.
// Questions only pertain to their respective code blocks. Answers are provided below the blocks with their appropriate explanations.


// ---------------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------------
// Question #1: What is the output of the following Java program?

interface BaseI {
    void method();
}

class BaseC {
    public void method() {
        System.out.println("Inside BaseC::method");
    }
}

class ImplC extends BaseC implements BaseI {
}

public class Main {
    public static void main(String[] args) {
        BaseI obj = new ImplC();
        obj.method();
    }
}

// Answer: Inside BaseC::method

// Explanation:  ImplC inherits the public void method() implementation directly from its parent class, BaseC. 
//               In Java, an inherited class method perfectly satisfies an interface contract requiring that same signature. 
//               When obj.method() is invoked, the inherited code executes.
// ---------------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------------


// Question #2: What is the result of attempting to compile and run the following Java code?

interface Pancake {
    void getSugary();
}

abstract class BlueBerry implements Pancake {
}

class BlueBerryPancake extends BlueBerry {
    public void getSugary() {
        System.out.println("Blueberry pancake is sugary.");
    }
}

class SourdoughBlueBerryPancake extends BlueBerryPancake {
    void getSugary(int s) {
        System.out.println("Sourdough pancake sugar level: " + s);
    }
}

// Answer: Compilation succeeds.

// Explanation:  An abstract class (BlueBerry) is not required to implement interface methods. 
//               The concrete subclass (BlueBerryPancake) correctly implements getSugary().
//               The method void getSugary(int s) in the final class uses a different parameter list, making it a valid method overload, which does not conflict with inheritance rules.
// ---------------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------------


// Question #3: What is the output of the following Java code execution?

public class Solution {
    public static void main(String[] args) {
        try {
            Float fl = new Float("3.0");
            int x = fl.intValue();
            byte b = fl.byteValue();
            double d = fl.doubleValue();
            System.out.println(x + b + d);
        } catch (NumberFormatException e) {
            System.out.println("bad number");
        }
    }
}

// Answer: 9.0

// Explanation:  The string "3.0" parses safely without throwing an exception. 
//               Converting it extracts x = 3 (int), b = 3 (byte), and d = 3.0 (double).
//               Adding them evaluates sequentially: 3 + 3 = 6. 
//               Adding the double 3.0 triggers numeric promotion, converting the entire expression to a double value of 9.0.
// ---------------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------------


// Question #4: Which of the following statements is true regarding covariant return types in Java method overriding?

// A. The overriding method can have a more restrictive access modifier than the overridden method.
// B. The overriding method can have a completely different primitive or independent class type as the return type.
// C. The overriding method can have a base type as the return type instead of the derived type.
// D. The overriding method can have derived type as the return type instead of the base type.

// Answer: D

// Explanation:
// A. Incorrect: Overriding methods cannot reduce the visibility of the parent method.
// B. Incorrect: The return type must be identical or a derived child type.
// C. Incorrect: This describes contravariance, which Java does not support for method overriding return types.
// D. Correct: Java supports covariant return types, which allows an overriding method to specialize its return type to a more specific subclass.
// ---------------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------------
