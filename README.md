# Mathall

<b> Mathall is a <a href="https://www.rust-lang.org/">Rust</a> program wich purpose is to make several calculations with matrices. At the first time, it was implemented in Java (<a href="https://github.com/Filipondios/The-Mathall-Project/releases/tag/v2.5.0">version 2.5.0</a> and earlier), but because making a program that only performs math operations in Java is not a very good idea, and perhaps the less optimal. Therefore, the project has been moved to Rust, speeding up arithmetic operations. </b>

## Features

- [X] : Implement the basic operations for matrices.
  - [X] : Matrices addittion 
  - [X] : Matrices substraction
  - [X] : Matrices dot product
  - [X] : Matrix determinant
  - [X] : Matrix inverse
  - [X] : Matrix traspose
  - [X] : Staggered matrix
  - [X] : Matrix Range
  - [X] : Gauss Method to a matrix
- [X] : Ability of reading matrices that the user type as the parameters of the program.

> **Note**
> The current number format that is being applied to the matrices and the operations is `f32` (32 bit floating point numbers). That means that the largest number that you can type is 3.40282347x10^38, and the smallest -3.40282347x10^38.

## How to use
### Basic Syntax
Mathall expects a parameter that specifies the matrices operation that the user wants to be performed, and at least 1 matrix. The syntax is the following one:
```bash
# This is only a example, "option" is not a real parameter
mathall --option "matrix1" "matrix2" ... "matrixN" # Large syntax
mathall -o "matrix1" "matrix2" ... "matrixN" # Short syntax
``` 
Most of Mathall's options only accepts one matrix as parameter:
```bash
mathall --option "matrix" # Large syntax
mathall -o "matrix1" # Short syntax
``` 
A matrix must be written with the next syntax: `"[{n1,n2,n3,...,nm1},{n4,n5,n6,...,nm2},...]"`. For example, lets traduce a 3x3 identity matrix to the Mathall matrix syntax:
```
[ 1   0   0 ]
[ 0   1   0 ] = "[{1,0,0},{0,1,0},{0,0,1}]"
[ 0   0   1 ]
```

### Options
The next options are available at Mathall:

| Option | Shortcut | Parameters Interval | Description |
|---|---|---|---|
| `--add` | `-a` | [2-N] | Adds two matrices or more |
| `--sub` | `-s` | [2-N] | Substracts two matrices or more |
| `--mult` | `-m` | [2-N] | Dot product of two matrices or more |
| `--traspose` | `-t` | [1] | Calculates a matrix traspose |
| `--inverse` | `-i` | [1] | Calculates the inverse of a matrix |
| `--determinant` | `-d` | [1] | Calculates the determinant of a matrix |
| `--staggered` | `-g` | [1] | Calculates the staggered matrix from a matrix |
| `--range` | `-r` | [1] | Calculates the range of a matrix |
| `--gauss` | `-g` | [1] | Applies the gauss method to a matrix |

> **Note**
> The parameters Interval column tells how many matrices can the user give as parameter to an option. For example, `[2-N]` means that you can give minimun 2 matrices and there is no max number of matrices to give. `[1]` means that you must give only 1 matrix as parameter.
