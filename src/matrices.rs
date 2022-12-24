/// Calculates the traspose of any f32 matrix
///
/// # Example
/// ```
/// let mut matrix: Vec<Vec<f32>> = vec![
///     vec![-8.0, 1.0, 3.0],
///     vec![1.0, 4.0, 4.0],
///     vec![3.0, 4.0, -2.0]
/// ];
/// matrix = matrices::matrix_traspose(&matrix);
/// ```
pub fn matrix_traspose(a: Vec<Vec<f32>>) -> Vec<Vec<f32>> {
    let _rows_a: usize = a.len();
    let _cols_a: usize = a[0].len();

    let mut result: Vec<Vec<f32>> = vec![vec![0.0; _cols_a]; _rows_a];

    for i in 0.._rows_a {
        for j in 0.._cols_a {
            result[i][j] = a[j][i];
        }
    }
    return result;
}

/// Calculates the addition of any two f32 matrices.
///
/// # Example
/// ```
/// let matrix1: Vec<Vec<f32>> = vec![
///     vec![1.0, 2.0, 3.0],
///     vec![4.0, 5.0, 6.0]
/// ];
/// let matrix2: Vec<Vec<f32>> = vec![
///     vec![9.0, 8.0, 7.0],
///     vec![6.0, 5.0, 4.0]
/// ];
/// // The result must be matrix1 + matrix2
/// let matrix = matrices::matrix_sum(matrix1, matrix2);
/// ```
///
/// # Panics
///
/// The function panics if both matrices have different dimensions. For example, to add
/// two matrices, both must have a NxM dimension, where N are the rows and M the columns.
///
pub fn matrix_sum(mut a: Vec<Vec<f32>>, b: &Vec<Vec<f32>>) -> Vec<Vec<f32>> {
    let _rows_a: usize = a.len();
    let _cols_a: usize = a[0].len();
    let _rows_b: usize = b.len();
    let _cols_b: usize = b[0].len();

    if _rows_a != _rows_b || _cols_a != _cols_b {
        panic!("Cannot add matrices. Incompatible dimensions.");
    }

    for i in 0.._rows_a {
        for j in 0.._cols_a {
            a[i][j] += b[i][j];
        }
    }
    return a;
}

/// Calculates the substraction of any two f32 matrices.
///
/// # Example
/// ```
/// let matrix1: Vec<Vec<f32>> = vec![
///     vec![9.0, 8.0, 7.0],
///      vec![6.0, 5.0, 4.0]
/// ];
/// let matrix2: Vec<Vec<f32>> = vec![
///     vec![1.0, 2.0, 3.0],
///     vec![4.0, 5.0, 6.0]
/// ];
/// // The result must be matrix1 - matrix2
/// let matrix = matrices::matrix_sub(matrix1, matrix2);
/// ```
///
/// # Panics
///
/// The function panics if both matrices have different dimensions. For example, to sub
/// two matrices, both must have a NxM dimension, where N are the rows and M the columns.
///
pub fn matrix_sub(mut a: Vec<Vec<f32>>, b: &Vec<Vec<f32>>) -> Vec<Vec<f32>> {
    let _rows_a: usize = a.len();
    let _cols_a: usize = a[0].len();
    let _rows_b: usize = b.len();
    let _cols_b: usize = b[0].len();

    if _rows_a != _rows_b || _cols_a != _cols_b {
        panic!("Cannot sub matrices. Incompatible dimensions.");
    }

    for i in 0.._rows_a {
        for j in 0.._cols_a {
            a[i][j] -= b[i][j];
        }
    }
    return a;
}

/// Calculates the dot product of any two f32 matrices.
///
/// # Example
/// ```
/// let matrix1: Vec<Vec<f32>> = vec![
///     vec![1.0, 2.0],
///     vec![3.0, 4.0]
/// ];
/// let matrix2: Vec<Vec<f32>> = vec![
///     vec![1.0, 0.0],
///     vec![0.0, 1.0]
/// ];
/// // The result must be matrix1 · matrix2
/// let matrix = matrices::matrix_mult(&matrix1, &matrix2);
/// ```
///
/// # Panics
///
/// The function panics if both matrices have incompatible dimensions. For example, to make
/// the dot product of two matrices A and B: A must have a NxM dimension, and B must have a
/// MxK. In other words, to multiply two matrices, the number of columns of the first matrix
/// must be the same as the number of rows of the second.
///
pub fn matrix_mult(a: Vec<Vec<f32>>, b: &Vec<Vec<f32>>) -> Vec<Vec<f32>> {
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
    return result;
}

/// Calculates the inverse of a f32 matrix with the Gauss-Jordan method.
///
/// # Example
/// ```
/// let matrix: Vec<Vec<f32>> = vec![
///     vec![1.0, 0.0],
///     vec![0.0, 1.0]
/// ];
/// matrix = matrices::matrix_inv(&matrix);
/// ```
///
/// # Panics
///
/// The function panics if the parameter matrix is not a square matrix. A square matrix
/// is a matrix with a NxN dimension.
///
pub fn matrix_inv(a: &Vec<Vec<f32>>) -> Vec<Vec<f32>> {
    let _rows_a: usize = a.len();
    let _cols_a: usize = a[0].len();

    if _rows_a != _cols_a {
        panic!("Cannot calculate the matrix inverse. Incompatible dimension.")
    }

    drop(_cols_a);
    let mut gauss_jordan: Vec<Vec<f32>> = Vec::new();

    for i in 0.._rows_a {
        let mut fila = Vec::new();

        for j in 0.._rows_a {
            fila.push(a[i][j]);
        }

        fila.extend(vec![0.0; _rows_a]);
        fila[i + _rows_a] = 1.0;
        gauss_jordan.push(fila);
    }

    for i in 0.._rows_a {
        // Encuentra el elemento pivot
        let mut pivot = i;
        for j in i + 1.._rows_a {
            if (gauss_jordan[j][i]).abs() > (gauss_jordan[pivot][i]).abs() {
                pivot = j;
            }
        }

        if pivot != i {
            gauss_jordan.swap(i, pivot);
        }

        if gauss_jordan[i][i] == 0.0 {
            panic!("The matrix has no inverse.");
        }

        let pivot_inverse: f32 = 1.0 / gauss_jordan[i][i];
        for j in i..2 * _rows_a {
            gauss_jordan[i][j] *= pivot_inverse;
        }

        for j in i + 1.._rows_a {
            let factor = gauss_jordan[j][i];
            for k in i..2 * _rows_a {
                gauss_jordan[j][k] -= factor * gauss_jordan[i][k];
            }
        }
    }

    for i in (0.._rows_a - 1).rev() {
        for j in 0..i {
            let factor = gauss_jordan[j][i];

            for k in i..2 * _rows_a {
                gauss_jordan[j][k] -= factor * gauss_jordan[i][k];
            }
        }
    }

    let mut inverse: Vec<Vec<f32>> = Vec::new();
    for i in 0.._rows_a {
        inverse.push(gauss_jordan[i][_rows_a..2 * _rows_a].to_vec());
    }
    return inverse;
}

/// Calculates the determinant of a f32 matrix with the Gauss-Jordan method.
///
/// # Example
/// ```
/// let matrix: Vec<Vec<f32>> = vec![
///     vec![1.0, 0.0],
///     vec![0.0, 1.0]
/// ];
/// matrix = matrices::matrix_det(&matrix);
/// ```
///
/// # Panics
///
/// The function panics if the parameter matrix is not a square matrix. A square matrix
/// is a matrix with a NxN dimension.
///
pub fn matrix_det(a: &Vec<Vec<f32>>) -> f32 {
    let _rows_a: usize = a.len();
    let _cols_a: usize = a[0].len();

    if _rows_a != _cols_a {
        panic!("Cannot calculate the matrix determinant. Incompatible dimension.")
    }

    drop(_cols_a);
    let mut gauss: Vec<Vec<f32>> = a.clone();
    let mut det: f32 = 1.0;

    for i in 0.._rows_a {
        let mut pivot: usize = i;

        for j in i + 1.._rows_a {
            if gauss[j][i].abs() > gauss[pivot][i].abs() {
                pivot = j;
            }
        }

        if pivot != i {
            det *= -1.0;
            gauss.swap(i, pivot);
        }

        if gauss[i][i] == 0.0 {
            return 0.0;
        }

        for j in (i + 1).._rows_a {
            let factor: f32 = gauss[j][i] / gauss[i][i];

            for k in i.._rows_a {
                gauss[j][k] -= factor * gauss[i][k];
            }
        }
    }

    for i in 0.._rows_a {
        det *= gauss[i][i];
    }

    return det;
}

/// Calculates a staggered matrix from a f32 matrix.
///
/// # Example
/// ```
/// let matrix: Vec<Vec<f32>> = vec![
///        vec![1.0, -1.0, 2.0],
///        vec![3.0, -2.0, 0.0],
///        vec![-2.0, 0.0, 1.0],
/// ];
/// matrix = matrices::matrix_estg(matrix);
/// ```
pub fn matrix_estg(mut a: Vec<Vec<f32>>) -> Vec<Vec<f32>> {
    let _rows_a: usize = a.len();

    for i in 0.._rows_a {
        // Buscamos el elemento pivot
        let mut pivot = i;
        for j in (i + 1).._rows_a {
            if a[j][i].abs() > a[pivot][i].abs() {
                pivot = j;
            }
        }

        a.swap(i, pivot);
        let pivot_val: f32 = a[i][i];

        if pivot_val != 0.0 {
            for j in (i + 1).._rows_a {
                let factor: f32 = a[j][i] / pivot_val;

                for k in (i + 1).._rows_a {
                    a[j][k] -= factor * a[i][k];
                }
                a[j][i] = 0.0;
            }
        }
    }
    return a;
}

/// Calculates the range of a f32 matrix.
///
/// # Example
/// ```
/// let matrix: Vec<Vec<f32>> = vec![
///        vec![1.0, 0.0, 0.0],
///        vec![0.0, 1.0, 0.0],
///        vec![0.0, 0.0, 1.0],
/// ];
/// let range: usize = matrices::matrix_range(matrix);
/// ```
pub fn matrix_range(mut a: Vec<Vec<f32>>) -> usize {
    a = gauss(a);
    let mut range: usize = 0;

    for i in 0..a.len() {
        for j in 0..a[0].len() {
            if a[i][j] != 0.0 {
                range += 1;
                break;
            }
        }
    }
    return if range == 0 { 1 } else { range };
}

/// Applies the gauss method to a f32 matrix.
///
/// # Example
/// ```
/// let matrix: Vec<Vec<f32>> = vec![
///        vec![1.0, 0.0, 0.0],
///        vec![0.0, 1.0, 0.0],
///        vec![0.0, 0.0, 1.0],
/// ];
/// let range: usize = matrices::gauss(matrix);
/// ```
pub fn gauss(mut a: Vec<Vec<f32>>) -> Vec<Vec<f32>> {
    let _rows_a = a.len();
    let _cols_a: usize = a[0].len();

    if a[0][0] == 0.0 {
        let mut _all_null_: bool = true;
        let mut not_null_row: usize = 1;

        for i in 0..a.len() {
            if a[i][0] != 0.0 {
                not_null_row = i;
                _all_null_ = false;
                break;
            }
        }

        if _all_null_ {
            panic!("Cannot make the Gauss Method on matrix. The first column is full of 0s.")
        }
        a.swap(0, not_null_row);
        drop(_all_null_);
        drop(not_null_row);
    }

    for i in 0..(_cols_a - 1) {
        for j in (i + 1).._rows_a {
            if a[j][i] != 0.0 {
                let _mcm_: f32 = a[j][i] / a[i][i];
                for k in 0.._cols_a {
                    a[j][k] -= a[i][k] * _mcm_;
                }
            }
        }
    }

    if a[_rows_a - 2][_cols_a - 2] == 0.0 {
        a[_rows_a - 1][_cols_a - 1] = 0.0;
    }
    return a;
}

/// Prints a f32 matrix in the console.
///
/// # Example
/// ```
/// let matrix1: Vec<Vec<f32>> = vec![vec![1.0, 0.0], vec![0.0, 1.0]];
/// matrix = matrices::matrix_print(&matrix1);
/// ```
pub fn matrix_print(a: &Vec<Vec<f32>>) -> () {
    for i in a.iter() {
        for j in i.iter() {
            print!("{} ", j);
        }
        println!();
    }
}
