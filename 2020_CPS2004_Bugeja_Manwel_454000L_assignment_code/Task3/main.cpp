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

class Var {
    double& v;

public:
    Var(double& val) : v(val){}
    double eval() {
        return v;
    }
};

class Const {
    const double v;

public:
    Const(double v) : v(v) {}
    double eval() {
        return v;
    }
};

class Plus {
    template <typename L, typename R>
    inline double apply(L a, R b) {
        return (a + b);
    }
};

template <typename L, typename Plus, typename R>
Expr<L, Plus, R> operator+(const L& l, const R& r) {
    return Expr<L, Plus, R>(l, r);
};

int main() {
    std::cout << "Hello, World!" << std::endl;
//    Var x = new Var();
//    Const c(14);
//
//    double res = ((x + x).eval(4);

    return 0;
}
