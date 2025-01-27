package echarts.utils.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import echarts.beans.yamlbeans.ChartConfig;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class YamlFileWriter {

    /**
     * Writes the ChartConfig object to a YAML file.
     *
     * @param chartConfig the ChartConfig object to be serialized
     * @param folderPath  the folder where the YAML file will be saved
     * @param fileName    the name of the YAML file
     * @throws IOException if an I/O error occurs during writing the file
     */
    public static void writeYamlToFile(ChartConfig chartConfig,
                                       String folderPath,
                                       String fileName) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File yamlFile = new File(folderPath + File.separator + fileName);

        objectMapper.writeValue(yamlFile, chartConfig);

        log.info("YAML file written to {}", yamlFile.getAbsolutePath());
    }
}
