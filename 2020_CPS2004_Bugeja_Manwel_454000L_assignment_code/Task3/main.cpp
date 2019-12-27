#include <iostream>
#include "Expression.h"
#include "Integral.h"

int main() {
    std::cout << "Hello, World!" << std::endl;

    // (10/x) + (2*x) when x = 4
    // = 10.5
    double res = ((C(10) / X()) + (C(2) * X())).eval(4);
    std::cout << res << std::endl;


    double res2 = integrate(((X() * X()) + C(2)*X() - C(3)),1,2,10000);
    std::cout << "Integrating x^2+2x-3 over 1<x<2:" << std::endl;
    std::cout << "Correct answer: " << (double)7/3 << std::endl;
    std::cout << "Result: " << res2 << std::endl;

    return 0;
}


