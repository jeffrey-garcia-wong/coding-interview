# Basic Mathematics

---
### Magnitude of power of 10 
| Power | Value         | Semantics        |
|-------|---------------|------------------|
| 10^1  | 10            | ten              |
| 10^2  | 100           | one hundred      |
| 10^3  | 1,000         | one thousand     |
| 10^4  | 10,000        | ten thousand     |
| 10^5  | 100,000       | hundred thousand |
| 10^6  | 1,000,000     | one million      |
| 10^7  | 10,000,000    | ten million      |
| 10^8  | 100,000,000   | hundred million  |
| 10^9  | 1,000,000,000 | one billion      |

---
### Magnitude of power of 2
| Power | Value         | No. of bit(s) | Storage Size                    |
|-------|---------------|---------------|---------------------------------|
| 2^1   | 2             | 1             | 2                               |
| 2^2   | 4             | 2             | 4                               |
| 2^3   | 8             | 3             | 8                               |
| 2^4   | 16            | 4             | 16                              |
| 2^5   | 32            | 5             | 32                              |
| 2^6   | 64            | 6             | 64                              |
| 2^7   | 128           | 7             | 128                             |
| 2^8   | 256           | 8             | 256                             |
| 2^9   | 512           | 9             | 512                             |
| 2^10  | 1,024         | 10            | 1,024 (~ one thousand)          |
| 2^11  | 2,046         | 11            | 2,046                           |
| 2^12  | 4,096         | 12            | 4,096                           |
| 2^13  | 8,192         | 13            | 8,192                           |
| 2^14  | 16,384        | 14            | 16,384 (~ ten thousand)         | 
| 2^15  | 32,768        | 15            | 32,768                          |
| 2^16  | 65,536        | 16            | 65,536                          |
| 2^20  | 1,048,576     | 20            | 1,048,576 (~ one million)       |
| 2^24  | 16,777,216    | 24            | 16,777,216                      |
| 2^30  | 1,073,741,824 | 30            | 1,073,741,824                   |
| 2^31  | 2,147,483,648 | 31            | 2,147,483,648 (~ two billions)  |
| 2^32  | 4,294,967,296 | 32            | 4,294,967,296 (~ four billions) |

---
### Signed and unsigned integer representation
> <b>Example</b><br/>
> 8 bits = 2^8 = 256
> <br/>
> - unsigned - store `2^32` different values, max value = `(2^32)-1`, min value = `0`
> - signed - store `(2^8)-1` different values, including `0`, `(2^7)-1` positive 
      values and `(2^7)-1` negative values

#### Explanation
When signed, the left-most bit is signed, only remaining 7 bits 
on the right for manipulating values.
```java
(0)000 0001 = +1 //min positive value 
(1)111 1111 = -1 // max negative value using 2's compliment 
(0)111 1111 = +127 // max positive value
(1)000 0000 = -127 // min negative value using 2's compliment
```

---
### Java 32 bit signed integer
> <b>Example</b><br/>
> 32 bits = 2^32 = 4,294,967,296
> - unsigned - store `2^32` different values, max value = `(2^32)-1`, min value = `0`
> - signed - store `2^32 -1` different values, including `0`, `(2^31)-1 = 2,147,483,647` positive values and `(2^31)-1 = 2,147,483,647` negative values

#### Explanation
When signed, the left-most bit is signed, only remaining 31 bits 
on the right for manipulating values.
```java
(0)000 0000 0000 0000 0000 0000 0000 0001 = +1 // min positive value
(1)111 1111 1111 1111 1111 1111 1111 1111 = -1 // max negative value using 2's compliment
(0)111 1111 1111 1111 1111 1111 1111 1111 = +2,147,483,647 // max positive value
(1)000 0000 0000 0000 0000 0000 0000 0000 = -2,147,483,647 // min negative value using 2's compliment
```

---
### Java signed right shift operatior `>>`
#### For positive integer
```java
(0)000 0000 0000 0000 0000 0000 0000 0001 = +1
```
shifting 1 bit towards right `+1 >> 1` produces
```java
(0)000 0000 0000 0000 0000 0000 0000 0000 = 0
```
#### For negative integer
```java
(1)000 0000 0000 0000 0000 0000 0000 0000 = -2,147,483,647
```
shifting 1 bit towards right `-2,147,483,647 >> 1` produces
```java
(1)100 0000 0000 0000 0000 0000 0000 0000 = -1,073,741,823
```

---
### Java signed left shift `<<`
#### For positive integer
```java
(0)000 0000 0000 0000 0000 0000 0000 0001 = +1
```
shifting 1 bit towards right `+1 << 1` produces
```java
(0)000 0000 0000 0000 0000 0000 0000 0010 = +2
```
#### For negative integer
```java
(1)111 1111 1111 1111 1111 1111 1111 1111 = -1
```
shifting 1 bit towards right `-1 << 1` produce
```java
(1)111 1111 1111 1111 1111 1111 1111 1110 = -2
```

---
### Unsigned right shift `>>>`
Consider the following operation:
```java
( 2,147,483,647 + 1) / 2
```
by adding one to 2,147,483,647 causes overflow and the value becomes
-2,147,483,647, dividing it by 2 will then produce a wrong answer 
-1,073,741,823 instead of 1,073,741,823.

##### Solution
> This can be workaround by using unsigned right shift
```java
(0)111 1111 1111 1111 1111 1111 1111 1111 = +2,147,483,647
```
after adding 1 overflow happens
```java
(1)000 0000 0000 0000 0000 0000 0000 0000 = -2,147,483,647
```
apply unsigned shifting 1 bit towards right (-2,147,483,647 >>> 1)
```java
(0)100 0000 0000 0000 0000 0000 0000 0000 = 1,073,741,824
```

---
### Binary conversion
#### binary to decimal conversion
Convert binary number 1111 to decimal:
```java
1*2^3 + 1*2^2 + 1*2^1 + 1*2^0 = 8 + 4 + 2 + 1 = 15
```
#### decimal to binary conversion
Convert decimal number 15 to binary:
```java
15 / 2 = 7 // remainder 1
7 / 2 = 3 // remainder 1
3 / 2 = 1 // remainder 1
1 / 2 = 0 // remainder 1
```

---
### Hexa-Decimal conversion
| HEX | DEC |
|-----|-----|
| 0   | 0   |
| 1   | 1   |
| 2   | 2   |
| 3   | 3   |
| 4   | 4   |
 | 5   | 5   |
| 6   | 6   |
| 7   | 7   |
| 8   | 8   |
| 9   | 9   |
| A   | 10  |
| B   | 11  |
| C   | 12  |
| D   | 13  |
| E   | 14  | 
| F   | 15  | 
| 1F  | 31  |
| 2F  | 47  |
 | 3F  | 63  |
