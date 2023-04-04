import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ex001 {
  static Logger logger;
  public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

    WriteJsonToFile();

  }

  static void WriteJsonToFile() throws FileNotFoundException, IOException, ParseException {
    
    //получние json строки
    String file1 = "ex001.json";
    String s1 = GetJsonData(file1);

    //запись в файл
    String file2 = "ex001.txt";
    WriteToFile(s1, file2);

  }

  static String GetJsonData(String file1) throws FileNotFoundException, IOException, ParseException {
    
    Object o = new JSONParser().parse(new FileReader(file1));

    JSONObject j = (JSONObject) o;

    String Surname = (String) j.get("фамилия");
    String Mark = (String) j.get("оценка");
    String Subject = (String) j.get("предмет");

    // System.out.println("фамилия :" + Surname);
    // System.out.println("оценка :" + Mark);
    // System.out.println("предмет: " + Subject);

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Студент " + Surname);
    stringBuilder.append(" получил " + Mark);
    stringBuilder.append(" по предмету " + Subject + " ");

    return stringBuilder.toString();

  }

  static void WriteToFile(String s1, String file2) {
  
    try (FileWriter writer = new FileWriter(file2, false)) {
      writer.write(s1);
      writer.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }

  //   try {
  //     Logger logger = Logger.getAnonymousLogger();
  //     FileHandler fileHandler = new FileHandler("log.txt", true);
  //     logger.addHandler(fileHandler);
  //     SimpleFormatter formatter = new SimpleFormatter();
  //     fileHandler.setFormatter(formatter);
  //     try (FileWriter writer = new FileWriter(filePath, false)) {
  //         writer.write(s);
  //         writer.flush();
  //         logger.log(Level.INFO, " ");
  //     } catch (Exception e) {
  //         e.printStackTrace();
  //         logger.log(Level.WARNING, e.getMessage());
  //     }
  //     fileHandler.close();
  // } catch (Exception e){
  //     e.printStackTrace();
  // }

  }
}