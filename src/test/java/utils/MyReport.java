package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyReport {
    File report;
    FileWriter myWriter;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final String fileName = "report.txt";

    public MyReport() {
        try {
            myWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getDuration(Date startTime, Date endTime) {
        long diff = endTime.getTime() - startTime.getTime();
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        String output = "";
        if(diffHours<10)
            output += "0";
        output += diffHours + ":";
        if(diffMinutes<10)
            output += "0";
        output += diffMinutes + ":";
        if(diffSeconds<10)
            output += "0";
        output += diffSeconds;

        return output;
    }

    public void createFile() {
        try {
            //create a file instance
            report = new File(System.getProperty("user.dir") + "/report.txt");

            //delete the file "report.txt" if it exists
            if (report.delete()) {
                System.out.println("Deleted the file: " + report.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }

            //create a file report.txt
            report.createNewFile();

        } catch(Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void writeToFile(String message){
        //write to the file report.txt
        try {
            myWriter.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //close the file
    public void closeFile(){
        try {
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateReport(Date startTime, Date endTime, String browsers) {
        writeToFile("Duration: " + getDuration(startTime, endTime) + "\n");
        writeToFile("Started: " + sdf.format(startTime) + "\n");
        writeToFile("Ended: " + sdf.format(endTime) + "\n");
        writeToFile("Browsers: " + browsers + "\n");
        closeFile();
    }
}
