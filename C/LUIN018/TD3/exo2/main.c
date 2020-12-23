#include "fonction1.h"
#include "fonction2.h"

int a,b,c;

int main()
{
    int x, y;
    a = 2;
    b = 3;
    c = 4;
    x = f(a);
    y = g();
    printf("%d %d %d %d %d\n", x, y, a, b, c);
    return 0;
}