package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public abstract class BaseModel {
    /**
     * check if line matched condition
     */
    private boolean lineMatch(String line, HashMap<String, String> where, String[] fields) {
        if (where == null) {
            return false;
        }

        HashMap<String, String> dataMap = line2Map(line, fields);

        for (Map.Entry<String, String> entry : where.entrySet()) {
            String field = entry.getKey();
            String value = entry.getValue();
            if (!value.equals(dataMap.get(field))) {
                return false;
            }
        }

        return true;
    }

    /**
     * convert line to map
     */
    private HashMap<String, String> line2Map(String line, String[] fields) {
        String[] dataFields = line.split("\t", -1);
        HashMap<String, String> dataMap = new HashMap<>();

        for (int i = 0; i < fields.length; i++) {
            String field = fields[i];
            dataMap.put(field, dataFields[i]);
        }

        return dataMap;
    }

    /**
     * build data line
     */
    private String buildDataLine(HashMap<String, String> dataMap, String[] fields) {
        StringBuilder dataLine = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            String field = fields[i];

            // add delimiter
            if (i != 0) {
                dataLine.append("\t");
            }

            if (dataMap.containsKey(field)) {
                dataLine.append(dataMap.get(field));
                continue;
            }
            dataLine.append("NULL");
        }

        return dataLine.toString();
    }

    /**
     * save object to db
     * if where not null => update it
     *
     * @return boolean
     */
    public boolean save(HashMap<String, String> where) {
        String[] fields;
        // store data to data directory
        Path dbFilePath = Paths.get("data/" + getTableName() + ".csv");
        File dbFile = new File(String.valueOf(dbFilePath));

        try {
            if (!dbFile.exists()) {
                // get fields from object
                fields = getFields();
                dbFile.getParentFile().mkdirs();
                dbFile.createNewFile();

                // add header line
                String headerLine = String.join("\t", fields);
                ArrayList<String> fileContent = new ArrayList<>();
                fileContent.add(headerLine);
                Files.write(dbFilePath, fileContent, StandardCharsets.UTF_8);
            } else {
                String fieldLine;
                try (BufferedReader br = new BufferedReader(new FileReader(dbFile))) {
                    fieldLine = br.readLine();
                }
                // get fields from db
                fields = fieldLine.split("\t", -1);
            }

            List<String> fileContent = new ArrayList<>(Files.readAllLines(dbFilePath, StandardCharsets.UTF_8));

            boolean isUpdate = false;
            Integer maxId = 0;
            // skip header line
            for (int i = 1; i < fileContent.size(); i++) {
                String line = fileContent.get(i);
                HashMap<String, String> oldDataMap = line2Map(line, fields);
                HashMap<String, String> newDataMap = toMap();
                Integer ID = Integer.valueOf(oldDataMap.get("ID"));
                newDataMap.put("ID", oldDataMap.get("ID"));

                if (ID > maxId) {
                    maxId = ID;
                }

                // build data line
                String dataLine = buildDataLine(newDataMap, fields);

                if (lineMatch(line, where, fields)) {
                    isUpdate = true;
                    fileContent.set(i, dataLine);
                }
            }

            // check if insert
            if (!isUpdate) {
                HashMap<String, String> newDataMap = toMap();
                newDataMap.put("ID", String.valueOf(maxId + 1));
                fileContent.add(buildDataLine(newDataMap, fields));
            }

            Files.write(dbFilePath, fileContent, StandardCharsets.UTF_8);
        } catch (IOException e) {
            // save fail
            System.err.println("save to db fail!");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * get info from db base on condition
     *
     * @return Object
     */
    public Object getInfo(HashMap<String, String> where) {
        List<Object> resultList = getList(where);
        if (resultList == null || resultList.size() <= 0) {
            return null;
        }

        return resultList.get(0);
    }

    /**
     * get list of info from db base on condition
     *
     * @return Object
     */
    public List<Object> getList(HashMap<String, String> where) {
        List<Object> resultList = new ArrayList<>();
        if (where == null) {
            return resultList;
        }

        Path dbFilePath = Paths.get("data/" + getTableName() + ".csv");
        File dbFile = new File(String.valueOf(dbFilePath));
        try {
            String fieldLine;
            try (BufferedReader br = new BufferedReader(new FileReader(dbFile))) {
                fieldLine = br.readLine();
            }
            // get fields from db
            String[] fields = fieldLine.split("\t", -1);

            List<String> fileContent = new ArrayList<>(Files.readAllLines(dbFilePath, StandardCharsets.UTF_8));

            // skip header line
            for (int i = 1; i < fileContent.size(); i++) {
                String line = fileContent.get(i);
                if (lineMatch(line, where, fields)) {
                    resultList.add(map2Object(line2Map(line, fields)));
                }
            }
        } catch (Exception e) {
            System.err.println("query db fail!");
            e.printStackTrace();
            return null;
        }

        return resultList;
    }

    /**
     * delete info from db base condition
     *
     * @return boolean
     */
    public boolean delete(HashMap<String, String> where) {
        if (where == null) {
            return false;
        }

        Path dbFilePath = Paths.get("data/" + getTableName() + ".csv");
        File dbFile = new File(String.valueOf(dbFilePath));
        try {
            String fieldLine;
            try (BufferedReader br = new BufferedReader(new FileReader(dbFile))) {
                fieldLine = br.readLine();
            }
            // get fields from db
            String[] fields = fieldLine.split("\t", -1);

            List<String> fileContent = new ArrayList<>(Files.readAllLines(dbFilePath, StandardCharsets.UTF_8));

            Iterator<String> i = fileContent.iterator();
            // skip header line
            i.next();
            while (i.hasNext()) {
                String line = i.next();
                if (lineMatch(line, where, fields)) {
                    i.remove();
                }
            }

            Files.write(dbFilePath, fileContent, StandardCharsets.UTF_8);
            return true;
        } catch (Exception e) {
            System.err.println("delete db fail!");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * get fields of object
     *
     * @return String[]
     */
    abstract public String[] getFields();

    /**
     * convert map to object
     *
     * @return Object
     */
    abstract public Object map2Object(HashMap<String, String> data);

    /**
     * convert object to map
     */
    abstract public HashMap<String, String> toMap();

    /**
     * get the table for the object
     */
    abstract public String getTableName();
}
