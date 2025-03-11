#include <stdio.h>
#include <assert.h>
#include <math.h>  
#include "math_operations.h"

void test_add() {
    assert(add(3, 2) == 5);
    assert(add(-1, -1) == -2);
    assert(add(0, 5) == 5);
    assert(add(-10, 10) == 0);
    
    printf("test add() success\n");
}

void test_subtract() {
    assert(subtract(5, 2) == 3);
    assert(subtract(2, 5) == -3);
    assert(subtract(-3, -3) == 0);
    assert(subtract(0, 10) == -10);

    printf("test subtract() success\n");
}

void test_multiply() {
    assert(multiply(4, 2) == 8);
    assert(multiply(-3, 3) == -9);
    assert(multiply(0, 5) == 0);
    assert(multiply(-2, -2) == 4);

    printf("test multiply() success\n");
}

void test_divide() {
    assert(divide(10, 2) == 5.0);
    assert(divide(7, 2) == 3.5);
    assert(divide(-6, 3) == -2.0);
    assert(divide(1, 4) == 0.25);
    assert(divide(0, 5) == 0.0);

    printf("try divide by 0..\n");

    assert(isnan(divide(10, 0)));  

    printf("test divide() success\n");
}

int main() {
    test_add();
    test_subtract();
    test_multiply();
    test_divide();

    printf("Test cases success!\n");
    return 0;
}
