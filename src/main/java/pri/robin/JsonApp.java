package pri.robin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class JsonApp {
    public static void main(String[] args) throws IOException {
        List<Record> records = new ArrayList<Record>();
        Record record;
        FileWriter writer = new FileWriter("records.json",true);

        for (int i = 0; i < 5; i++) {
            record = new Record();
            record.setCategory(i);
            record.setCost(i);
            record.setTime(new Timestamp(System.currentTimeMillis()));
//            writer.write(JSONObject.toJSONString(record)+"\n");
//            records.add(record);
        }

//        File file = new File("records.json");
//        FileOutputStream out = new FileOutputStream(file);

        writer.close();

        FileReader reader = new FileReader("records.json");
        int bufflen = 10;
        char[] buff = new char[bufflen];
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while ((i = reader.read(buff)) > 0) {
            if (i < bufflen) {
               builder.append(buff,0,i);
            } else {
                builder.append(buff);
            }

        }
        System.out.println(builder.toString());
        String[]  recordList = builder.toString().split("\n");
//        List<Record> recordList = JSON.parseObject(builder.toString(),new TypeReference<ArrayList<Record>>() {});
//        JSONArray obj = JSONObject.parseArray(builder.toString());
       for (String record1: recordList)
       {
           record = JSON.parseObject(record1,new TypeReference<Record>(){});
           System.out.println(record.getTime().toString()+","+record.getCategory());

       }

    }
}
