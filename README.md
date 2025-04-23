Compression is a process used to make large files smaller so that they do not use up as much memory. A simple form of binary compression looks at a file and records how many instances of each 1 and 0 appear consecutively in a sequence.

For example:
1 0 1 1 1 0 0 0 0 0 1 1 1 1 1 1 0 0 1 1 1
Could be compressed to read:
1 1 1 0 3 1 5 0 6 1 2 0 3 1
Because the first series of numbers has one 1, one 0, three 1’s, five 0’s, six 1’s, two 0’s and
three 1’s

Instructions:

1. Take the starter code from github
2. Create a method that takes data_raw.txt, applies the compression algorithm, and outputs the compressed data into a new file. The input to this method should be two strings, one being the input filename the other being the new file name
3. Create a method that takes data_compressed.txt, applies the decompression algorithm, and outputs the decompressed data into a new file. The input to this method should be two strings, one being the input filename the other being the new file name
4. Make sure you document your code, including comments that explain your testing and debugging.
