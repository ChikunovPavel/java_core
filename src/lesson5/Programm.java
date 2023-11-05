package lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Создать 2 текстовых файла, примерно по 50-100 символов в каждом()
 * Написать метод, склетвающий эти файлы, то есть вначале идет из первого файла,потом идет текст из второго
 * написать метод, который проверяет, присутствуюет ли указанное пользователем слова в файле(работам только с
 * Написать метод, проверяющий есть ли указанное слово в папке
 */


public class Programm {
    private static Random random = new Random();
    private static final String TO_SEARCH = "GeekBrains";
    private static final int CHAR_BOUND_L = 65;//НАЧАЛО
    private static final int CHAR_BOUND_H = 90;//КОНЕЦ

    public static void main(String[] args) throws IOException {

        System.out.println(generateSymbols(50));
        writeFileContents("sample01.txt", 90);
        writeFileContents("sample01.txt", 10);
        writeFileContents("sample02.txt", 10);
        concatenate("sample01.txt","sample02.txt","sampleOut.txt");

        String[] fileNames = new String[10];
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = "file_" + i + ".txt";
            writeFileContents(fileNames[i],90,2 );
            System.out.println("file create " + fileNames[i]);
        }

        List<String> lstResult = searchMatch(new File("."),TO_SEARCH);
        for (String s : lstResult) {
            System.out.println("file have serch words " + s);
        }

    }

    /**
     * метод геенерации последовательности символов
     *
     * @param amount количество символов
     * @return
     */
    private static String generateSymbols(int amount) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            stringBuilder.append((char) random.nextInt(CHAR_BOUND_L, CHAR_BOUND_H + 1));

        }
        return stringBuilder.toString();
    }

    /**
     * Записать последовательность символов в файл
     *
     * @param fileName
     * @param lenght
     */
    private static void writeFileContents(String fileName, int lenght) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(generateSymbols(lenght).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFileContents(String fileName, int lenght, int world) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            for (int i = 0; i < world; i++) {
                if (random.nextInt(2) == 0) ;//33%
                {
                    fileOutputStream.write(TO_SEARCH.getBytes());
                }
            }
            fileOutputStream.write(generateSymbols(lenght).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void concatenate(String fileName1, String fileName2, String fileOut){
        // На запись
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileOut)){
            int c;
            // На чтение 1
            try(FileInputStream filterInputStream = new FileInputStream(fileName1)){
                while ((c = filterInputStream.read()) != -1)
                    fileOutputStream.write(c);
            }
            catch (IOException e){
                e.printStackTrace();
            }

            // На чтение 2
            try(FileInputStream filterInputStream = new FileInputStream(fileName2)){
                while ((c = filterInputStream.read()) != -1)
                    fileOutputStream.write(c);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    static boolean searchInFile(String fileName, String search) {
        // GeekBrains
        // GeeekBrains;
        try (FileInputStream filterInputStream = new FileInputStream(fileName)) {
            byte[] searchData = search.getBytes();
            int c;
            int counter = 0;
            while ((c = filterInputStream.read()) != -1) {
                if (c == searchData[counter]){
                    counter++;
                }
                else{
                    counter = 0;
                    if (c == searchData[counter]){
                        counter++;
                        continue;
                    }
                }
                if (counter == searchData.length){
                    return true;
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

    static List<String> searchMatch(File dir, String search) throws IOException{
        List<String> list = new ArrayList<>();
        File[] files = dir.listFiles();
        if (files == null)
            return list;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
                continue;
            if (searchInFile(files[i].getCanonicalPath(), search)){
                list.add(files[i].getName());
            }
        }
        return list;
    }


}
