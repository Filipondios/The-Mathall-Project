/// Calculates the traspose of any f32 matrix 
/// 
/// # Example
/// ```
/// let mut matrix: Vec<Vec<f32>> = vec![vec![1, 2, 3], vec![4, 5, 6], vec![7, 8, 9]];
/// matrix = matrices::matrix_traspose(&matrix);
/// ```
pub fn matrix_traspose(a: &Vec<Vec<f32>>) -> Vec<Vec<f32>> {
    let rows: usize = a.len();
    let cols: usize = a[0].len();

    let mut result: Vec<Vec<f32>> = vec![vec![0.0; cols]; rows];

    for i in 0..rows {
        for j in 0..cols {
            result[i][j] = a[j][i];
        }
    }
    result
}

pub fn matrix_sum(a: &Vec<Vec<f32>>, b: &Vec<Vec<f32>>) -> Vec<Vec<f32>> {
    let _rows_a: usize = a.len();
    let _cols_a: usize = a[0].len();
    let _rows_b: usize = b.len();
    let _cols_b: usize = b[0].len();

    if _rows_a != _rows_b || _cols_a != _cols_b {
        panic!("Cannot add matrices. Incompatible dimensions.");
    }

    let mut result: Vec<Vec<f32>> = vec![vec![0.0; _rows_a]; _cols_a];

    for i in 0.._rows_a {
        for j in 0.._cols_a {
            result[i][j] = a[i][j] + b[i][j];
        }
    }
    result
}

pub fn matrix_sub(a: &Vec<Vec<f32>>, b: &Vec<Vec<f32>>) -> Vec<Vec<f32>> {
    let _rows_a: usize = a.len();
    let _cols_a: usize = a[0].len();
    let _rows_b: usize = b.len();
    let _cols_b: usize = b[0].len();

    if _rows_a != _rows_b || _cols_a != _cols_b {
        panic!("Cannot sub matrices. Incompatible dimensions.");
    }

    let mut result: Vec<Vec<f32>> = vec![vec![0.0; _rows_a]; _cols_a];

    for i in 0.._rows_a {
        for j in 0.._cols_a {
            result[i][j] = a[i][j] - b[i][j];
        }
    }
    result
}

pub fn matrix_mult(a: &Vec<Vec<f32>>, b: &Vec<Vec<f32>>) -> Vec<Vec<f32>> {
    let _rows_a: usize = a.len();
    let _cols_a: usize = a[0].len();
    let _rows_b: usize = b.len();
    let _cols_b: usize = b[0].len();

    if _cols_a != _rows_b {
        panic!("Cannot mult matrices. Incompatible dimensions.");
    }

    let mut result: Vec<Vec<f32>> = vec![vec![0.0; _cols_b]; _rows_a];

    for i in 0.._rows_a {
        for j in 0.._cols_b {
            for k in 0.._cols_a {
                result[i][j] += a[i][k] * b[k][j];
            }
        }
    }
    result
}

pub fn matrix_inv(a: &Vec<Vec<f32>>) -> Vec<Vec<f32>> {

    let _rows_a: usize = a.len();
    let _cols_a: usize = a[0].len();

    if _rows_a != _cols_a {
        panic!("Cannot make the inverse of the matrix. Incompatible dimension.")
    }

    drop(_cols_a);
    let mut result: Vec<Vec<f32>> = vec![vec![0.0; _rows_a]; _rows_a];
    let mut iden: Vec<Vec<f32>> = vec![vec![0.0; _rows_a]; _rows_a];



    result
}

pub fn matrix_print(a: &Vec<Vec<f32>>) -> () {
    for i in a.iter() {
        for j in i.iter() {
            print!("{} ", j);
        }
        println!();
    }
}

pub fn matrix_det(a: &Vec<Vec<f32>>) -> &Vec<Vec<f32>> {
    let pointer: &Vec<Vec<f32>> = a;
    pointer
}
