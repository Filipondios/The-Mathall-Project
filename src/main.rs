mod matrices;

fn main() {
    let vect1: Vec<Vec<i32>> = vec![vec![1, 2, 3], vec![4, 5, 6]];
    let vect2: Vec<Vec<i32>> = vec![vec![10, 11], vec![20, 21], vec![30, 31]];
    
    let vect3: Vec<Vec<i32>> = vec![vec![1, 0, 0], vec![0, 1, 0], vec![0, 0, 1]];
    let vect4: Vec<Vec<i32>> = vec![vec![0, 0, 1], vec![0, 1, 0], vec![1, 0, 0]];
    let vect5: Vec<Vec<i32>> = vec![vec![1, 2, 3], vec![4, 5, 6], vec![7, 8, 9]];

    let mut result: Vec<Vec<i32>> = matrices::matrix_mult(&vect1, &vect2);
    matrices::matrix_print(&result);
    println!();

    result = matrices::matrix_mult(&vect5, &vect3);
    matrices::matrix_print(&result);
    println!();

    result = matrices::matrix_mult(&vect5, &vect4);
    matrices::matrix_print(&result);
    println!();

    result = matrices::matrix_sum(&vect3, &vect4);
    matrices::matrix_print(&result);
    println!();

    result = matrices::matrix_sub(&vect5, &vect3);
    matrices::matrix_print(&result);
}