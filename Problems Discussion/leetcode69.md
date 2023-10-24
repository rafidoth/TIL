# 69. Sqrt(x)

[Problem Link](https://leetcode.com/problems/sqrtx/)

Given a non-negative integer `x`, return *the square root of* `x` *rounded down to the nearest integer*. The returned integer should be **non-negative** as well. You **must not use** any built-in exponent function or operator.

```java
class Solution {
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        while(start<=end){
            int mid = start + (end - start )/2;
            long sqr = (long)mid*(long)mid;
            if(sqr == x) return mid;
            else if(sqr < x) start = mid +1;
            else end = mid -1;
        }
        return end;
    }
}
```
