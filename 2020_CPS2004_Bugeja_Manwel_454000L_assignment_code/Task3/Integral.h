//
// Created by Manwel Bugeja on 27/12/2019.
//

#ifndef TASK3_INTEGRAL_H
#define TASK3_INTEGRAL_H

#include "Expression.h"

template <typename L, typename BinOp, typename R>
double integrate(Expr<L, BinOp, R> expr, double lower, double upper, double divs) {
    double h = (upper - lower)/divs;

    double y0 = expr.eval(lower);
    double yn = expr.eval(lower + divs * h);

    double sum;
    for (int i = 1; i < divs; ++i) {
        sum = sum + expr.eval(lower + i * h);
    }

    return (h/2)*(y0 + yn + 2*sum);
}


#endif //TASK3_INTEGRAL_H
