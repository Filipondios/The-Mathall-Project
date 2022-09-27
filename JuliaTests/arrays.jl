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


