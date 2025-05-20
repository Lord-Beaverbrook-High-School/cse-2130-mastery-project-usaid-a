import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String read_data = read("C:\\Users\\48258003\\IdeaProjects\\file compressor and decompressor\\src\\data_raw.txt");
        System.out.println(read_data); //prints read data
        String compressed_data = compress(read_data); //compresses the read data
        String decompressed_data = decompress(compressed_data);
        //System.out.println(compressed_data); //prints compressed data
        write("decompressed data",decompressed_data);
    }
    public static String compress(String data){
        int n = data.length();
        int count = 1;
        //StringBuilder is a class that is an object that stores data similarly to a string but each character is mutable unlike a string, and it is better for constant changes efficiency wise
        StringBuilder CompressedStringBuilder = new StringBuilder();
        for (int i = 1; i < n; i++) {
            if (data.charAt(i) == data.charAt(i - 1)) {
                count++; //counts occurrences of characters
            } else {
                CompressedStringBuilder.append(count).append(data.charAt(i - 1));
                count = 1; // Reset count for the new character
            }
        }
        CompressedStringBuilder.append(count).append(data.charAt(n - 1));//finishes the very last character
        return CompressedStringBuilder.toString();
    }
    public static String decompress(String CompressedData){
        StringBuilder decompressed_data = new StringBuilder();
        int numStart = 0;
        for(int i = 0; i < CompressedData.length(); i++) {
            if(Character.isDigit(CompressedData.charAt(i))) {
                continue;
            }
            int count = Integer.parseInt(CompressedData.substring(numStart, i));
            decompressed_data.append(String.valueOf(CompressedData.charAt(i)).repeat(count));
            numStart = i + 1;

            }
        return CompressedData;
    }

    public static String read(String File_name) {
        File MyObj = new File(File_name);
        try {
            Scanner MyReader = new Scanner(MyObj);
            while (MyReader.hasNextLine()) {
                String data = MyReader.nextLine();

                String result = data.replaceAll(" ", "");
                MyReader.close();
                return result;
            }
            MyReader.close();
        } catch (Exception e) {
            System.out.println("file not found");
            e.printStackTrace();
            return File_name;
        }
        return File_name;
    }

    public static void write(String FileName,String data) throws IOException {
        boolean append = true; //if file is already created needed for user to decide if the data will overwrite it or be added
        File file = new File(FileName);
        try {
            if (file.createNewFile()){
                System.out.println("new file created" + file.getName());
            }
            else{
                System.out.println("file already exists");
                Scanner myObj = new Scanner(System.in);
                System.out.println("would you like to add to the file or overwrite it? add/overwrite");
                String AddOrOverWrite = myObj.nextLine();
                if (AddOrOverWrite.equals("add")){
                    append = true;
                }
                else if (AddOrOverWrite.equals("overwrite")) {
                    append = false;
                }
                else {
                    System.out.println("invalid input data will be added to the file");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        FileWriter writer = new FileWriter(FileName,append);//true adds to the file false overwrites it
        writer.append(data);
        writer.close();
    }
}
