mod matrices;

fn main() {
    /* Represent the identity matrix:
     *   1  0   0
     *   0  1   0
     *   0  0   1
     * As a vector of vectos of f32.*/
    let vect1: Vec<Vec<f32>> = vec![vec![1.0, 0.0, 0.0], vec![0.0, 1.0, 0.0], vec![0.0, 0.0, 1.0]];
    /* Represent any matrix:
     *   1  2   3
     *   4  5   6
     *   7  8   9
     * As a vector of vectos of f32.*/
    let vect2: Vec<Vec<f32>> = vec![vec![1.0, 2.0, 3.0], vec![4.0, 5.0, 6.0], vec![7.0, 8.0, 9.0]];

    let mut result: Vec<Vec<f32>> = matrices::matrix_traspose(&vect1);
    matrices::matrix_print(&result);
    println!();
    result = matrices::matrix_sum(&vect1, &vect2);
    matrices::matrix_print(&result);
    println!();
    result = matrices::matrix_sub(&vect1, &vect2);
    matrices::matrix_print(&result);
    println!();
    result = matrices::matrix_mult(&vect1, &vect2);
    matrices::matrix_print(&result);
    println!();
}