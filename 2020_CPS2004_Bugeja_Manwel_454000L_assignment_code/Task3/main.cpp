#include <iostream>

template <typename L, typename BinOp, typename R>
class Expr {
    L& l_;
    R& r_;

public:
    Expr(const L& l, const R& r) : l_(l), r_(r) {};
    double eval() {
        return BinOp::apply(l_, r_);
    }
};

class Plus {
    inline double apply(double a, double b) {
        return (a + b);
    }
};

template <typename L, typename R>
Expr<L, Plus, R> operator+(const L& l, const R& r) {
    return Expr<L, Plus, R>(l, r);
};


int main() {
    std::cout << "Hello, World!" << std::endl;

//    double res = ((x() * x())) + c(14)).eval(4);

    return 0;
}
