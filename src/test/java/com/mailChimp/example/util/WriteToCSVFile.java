package com.mailChimp.example.util;

import com.mailChimp.example.domain.Leader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteToCSVFile {
    public static void writeLeadershipInfoToFile(ArrayList<Leader> leaderArrayList){
        try {
            PrintWriter writer = new PrintWriter(new File("leaders.csv"));
            for(Leader leader: leaderArrayList)
                writer.println(getLeaderInCSVString(leader));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String getLeaderInCSVString(Leader leader) {
        return leader.getName() + ", "+ leader.getTitle() + "," +getCSVFormattedDescription(leader);
    }

    private static String getCSVFormattedDescription(Leader leader) {
        return "\"" + leader.getDecscription().replaceAll("\n", " ").replaceAll("\t", " ") + "\"";
    }
}
