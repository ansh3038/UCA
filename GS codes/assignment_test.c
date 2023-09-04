#include<stdio.h>
#include<assert.h>
#include"assignment.c"
void test(){
    assert(bitAnd(2,3)==2);  //1.1
    assert(bitAnd(-1,0)==0); //1.2

    assert(bitXor(5,2)==7);  //2.1
    assert(bitXor(5,7)==2);  //2.2

    assert(sign(-23)==-1);   //3.1
    assert(sign(0)==0);      //3.2
    assert(sign(23)==1);     //3.3

    assert(getByte(305419896,1)==86); //4.1 
    assert(getByte(305419896,0)==120);//4.2

    assert(logicalShift(2271560481,4)==141972530); //5.1
    assert(logicalShift(8,2)==2);                  //5.2
    assert(logicalShift(-1,4)==268435455);         //5.3
    assert(logicalShift(-2147483648,3)==268435456);//5.4

    assert(invert(54,2,4)==10);
    assert(invert(23,2,2)==27);
    // assert(invert(-1,1,31)==0);

    assert(conditional(2,4,5)==4);
    assert(conditional(0,3,4)==4);

    assert(bang(2)==0);
    assert(bang(0)==1);
    
    
}
int main(){
    test();
    printf("success");
    return 0;
}