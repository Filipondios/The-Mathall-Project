# Create a 3-element vector type Int64 (Def)
arr = [1,2,3]
# Create a 3-element vector type Float64 (Def with .)
arr = [1.2, 2.5, 0]
# Create a 3 undefined vector = [0,0,0]
arr = Array{Int64}(undef,3)
# Create a 3 dimension array undefined
arr = Array{Int64}(undef,3,3,3)
# You can create an array with different types lol (tan is a function)
arr = [1,"string",tan,pi]
# Create an empty array
arr = Int64[] # arr = String[]

# Create a 2 Dymension array (Matrix) without commas
matrix = [1 2 3 4 5 6 7 8 9 10] # This is a 1x10 matrix
# Add another row with the semicolon
matrix = [1 2 3 4 5 ; 6 7 8 9 10] # This is a 2x5 matrix

# Creating an array using range objects with the collect() function
arr = collect(1:5) # eq. [1,2,3,4,5]
# Creating an array using range objects with the collect() function
arr = collect(1.5:5.5) # eq. [1.5,2.5,3.5,4.5,5.5]
# Creating arrays with other collect() implementation
# The implementation is start:step:stop
arr = collect(0:5:50) # eq. [0,5,10,15,..,50]
# Creating an array with the elipsis operator (...)
arr = [0:10...] # eq. [1,2,3,4,5,...,9,10]
# Use the range & collect functions
# the function  range(1, stop=150, step=10) returns 1:10:141
arr = collect(range(1, stop=150, step=10))
# Use a for to create am array
arr = [n^2 for n in 1:10] # eq. [1,4,9,16,25,36,...,100]
# Create a matrix with a for function
matrix = [n*m for n in 1:10, m in 1:10] 
# Create an array using for and collect dunction
arr = collect(n^2 for n in 1:5) # eq. [1,4,9,16,25]

# Populate a matrix with 0s
matrix = zeros(4,5) # eq. a 4x5 matrix full of 0s. Def type is Float
# Pulate a matrix with a specific type
matrix =  zeros(Int64,4,5)
# Pulate a matrix with 1s
matrix =  ones(4,5) # eq. a 4x5 matrix full of 1s. Def type is Float
# Populate a matrix with random values from 0 to 1
matrix = rand(4,5)
# Populate a matrix with normally distributed random numbers 
# with mean=0 and standard deviation(SD)=1.
matrix = randn(4,5)
# Fill an array with a specific value
arr = fill(100,5) # eq. [100,100,100,100,100]
# Fill a matrix with a specific value
matrix = fill(69,3,3) #eq. a matrix full of 69 values
# Override an array with a specific value
fill!(matrix,69)
