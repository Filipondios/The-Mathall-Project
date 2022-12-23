mod matrices;

fn main() {
    /* Represent the identity matrix:
     *   1  0   0
     *   0  1   0
     *   0  0   1
     * As a vector of vectos of f32.*/
    let mut vect1: Vec<Vec<f32>> = vec![
        vec![1.0, 0.0, 0.0],
        vec![0.0, 0.0, 0.0],
        vec![0.0, 0.0, 1.0],
    ];
    /* Represent any matrix:
     *   1  2   3
     *   4  5   6
     *   7  8   9
     * As a vector of vectos of f32.*/
    let vect2: Vec<Vec<f32>> = vec![
        vec![2.0, 3.0, 1.0],
        vec![6.0, 9.0, 3.0],
    ];

    //let result: Vec<Vec<f32>> = matrices::matrix_range(&vect1);
    //matrices::matrix_print(&result);

    println!("El rango es: {}", matrices::matrix_range(vect2));
}