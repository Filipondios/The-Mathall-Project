# Mathall

<b> Mathall is a <a href="https://www.rust-lang.org/">Rust</a> program wich purpose is to make several calculations with matrices. At the first time, it was implemented in Java (<a href="https://github.com/Filipondios/The-Mathall-Project/releases/tag/v2.5.0">version 2.5.0</a> and earlier), but because making a program that only performs math operations in Java is not a very good idea, and perhaps the less optimal. Therefore, the project has been moved to Rust, speeding up arithmetic operations. </b>

## Main Goals

- [ ] : Implement the basic operations for matrices.
  - [X] : Matrices addittion 
  - [X] : Matrices substraction
  - [X] : Matrices dot product
  - [X] : Matrix determinant
  - [X] : Matrix inverse
  - [X] : Matrix traspose
  - [ ] : Appy Gauss Method to a matrix
  - [ ] : Staggered matrix
- [ ] : Ability of reading matrices that the user type as the parameters of the program.
- [ ] : Instead of storing floating point numbers in the matrices, store integer numbers & fractions.
- [ ] : Higher modularity (Make a better & cleaner structure for the user nderstanding)

> **Note**
> The current number format that is being applied to the matrices and the operations is `f32` (32 bit floating point numbers). That means that the largest number that you can type is 3.40282347x10^38, and the smallest -3.40282347x10^38.
