use std::{env, process::exit};
mod matrices;

fn main() {

    let args: Vec<String> = env::args().collect();
    println!("{:?}", args);
    if args.len() == 1 {
        println!("Mathall must recieve some parameters. Nothing to do.");
        exit(0);
    }
    
    /* 
    Operations with matrices options:
        --add [[]] [[]] ... [[]] : Matrices addition
        --sub [[]] [[]] ... [[]]: Matrices substraction
        --mult [[]] [[]] ... [[]] : Matrices dot-product
        --traspose [[]] : Traspose of a matrix
        --inverse [[]] : Inverse of a matrix
        --determinant [[]] : Matrix determinant
        --staggered [[]] : Staggered matrix from a matrix
        --range [[]] : Range of a matrix
        --gauss [[]] : Apply the Gauss method to a matrix

    Operations with matrices shortcuts:
        -a : --add [[]] [[]] : Matrices addition
        -s: --sub [[]] [[]] : Matrices substraction
        -m: --mult [[]] [[]] : Matrices dot-product
        -t: --traspose [[]] : Traspose of a matrix
        -i: --inverse [[]] : Inverse of a matrix
        -d: --determinant [[]] : Matrix determinant
        -g: --staggered [[]] : Staggered matrix from a matrix
        -r: --range [[]] : Range of a matrix
        -g: --gauss [[]] : Apply the Gauss method to a matrix
*/
    let mut main_matrix: Vec<Vec<f32>> = string_convert(&args[2]); // First matrix from the arguments
    let mut matrix_stack: Vec<Vec<Vec<f32>>> = Vec::new(); // Stack with all the matrices except the first
    let option: String = args[1].clone();

    if args.len()>3 {        
        for i in 3..args.len() {
            matrix_stack.push(string_convert(&args[i]));
        }
    }

    if option == "--add" || option == "-a" {
        for i in matrix_stack.iter() {
            main_matrix = matrices::matrix_sum(main_matrix, i);
        }
    }
    else if option == "--sub" || option == "-s" {
        for i in matrix_stack.iter() {
            main_matrix = matrices::matrix_sub(main_matrix, i);
        }
    }
    else if option == "--mult" || option == "-m" {
        for i in matrix_stack.iter() {
            main_matrix = matrices::matrix_mult(main_matrix, i);
        }
    }

    else if option == "--traspose" || option == "-t" {
        main_matrix = matrices::matrix_traspose(main_matrix);
    }
    else if option == "--inverse" || option == "-i" {
        main_matrix = matrices::matrix_inv(&main_matrix);
    }
    else if option == "--determinant" || option == "-d" {
        println!("The determinant of the parameter matrix is: {}\n", matrices::matrix_det(&main_matrix));
        exit(0);
    }
    else if option == "--staggered" || option == "-g" {
        main_matrix = matrices::matrix_estg(main_matrix);
    }
    else if option == "--range" || option == "-r" {
        println!("The range of the parameter matrix is: {}\n", matrices::matrix_range(main_matrix));
        exit(0);
    }
    else if option == "--gauss" || option == "-g" {
        main_matrix = matrices::gauss(main_matrix);
    }
    else{
        print!("Option {:?} unrecognized.", option);
        exit(0);
    }
    
    println!("The resultant matrix is: \n");
    matrices::matrix_print(&main_matrix);
    println!();
}

fn string_convert(cadena: &String) -> Vec<Vec<f32>> {
    let cadena: String = cadena.replace("[", "").replace("]", "").replace(" ", "");
    let filas: Vec<&str> = cadena.split("},{").collect();

    let mut matriz: Vec<Vec<f32>> = Vec::new();
    for fila in filas {
        let mut vec: Vec<f32> = Vec::new();
        for valor in fila.replace("{", "").replace("}", "").split(",") {
            match valor.parse::<f32>() {
                Ok(n) => vec.push(n),
                Err(_) => {
                    println!("The parameter {:?} cannot be parsed to a matrix.", vec);
                }
            }
        }
        matriz.push(vec);
    }
    return matriz;
}