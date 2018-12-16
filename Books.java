import java.io.*;
import java.util.Formatter;

public class Books {

    private String bookName, authorName, ISBN10;
    private int inStock;

    Books(int inStock){
        this.inStock = inStock;
    }

    Books(String bookName, String authorName, String ISBN10, int inStock){
        this.bookName = bookName;
        this.authorName = authorName;
        this.ISBN10 = ISBN10;
        this.inStock = inStock;
    }

    public void writeBookDetails(String filePath){
        try{
            Formatter f = new Formatter(filePath);
            f.format("Title: %s\r\n",bookName);
            f.format("Author: %s\r\n",authorName);
            f.format("ISBN-10: %s\r\n",ISBN10);
            f.format("In Stock: %s\r\n",inStock);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    int getInStock() {
        return inStock;
    }

    void modifyFile(String filePath, String oldString, String newString){
        File bookFile = new File(filePath);
        String oldContent = "";
        BufferedReader bufferedReader = null;
        FileWriter fileWriter = null;

        try{
            bufferedReader = new BufferedReader(new FileReader(bookFile));
            String line = bufferedReader.readLine();

            while(line != null){
                oldContent = oldContent +  line + System.lineSeparator();
                line = bufferedReader.readLine();
            }

            String newContent = oldContent.replaceAll(oldString, newString);
            fileWriter = new FileWriter(filePath);
            fileWriter.write(newContent);

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        finally {
            try{
                bufferedReader.close();
                fileWriter.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}
