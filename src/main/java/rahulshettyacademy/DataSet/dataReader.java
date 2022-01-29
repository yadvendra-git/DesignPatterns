package rahulshettyacademy.DataSet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class dataReader {

    public List<HashMap<String, String>> getJsonData (String jsonFilePath) throws IOException {
//1. convert json file content to json string
        //we need to take help of FileUtils method of "apache commons io" to convert file content to string, copy the dependency to POM.xml
      String jsonContent=  FileUtils.readFileToString(new File("reservationDetails.json"), StandardCharsets.UTF_8);

        //take help of Jackson API to convert file string to hashmap,
        //readvalue method will convert the file content which is converted to string now to hasmap and then wrap it to the List

        ObjectMapper mapper=new ObjectMapper();
        //Typereference from Java is used to unmarshal and marshal the data, in this case typereference is unmarshalling
        // Json to List of hashmap
        List<HashMap<String, String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
        return data;


    }
}
