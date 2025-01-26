package echarts.utils.yamlUtils;

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
public class YamlFileReader {
    private static final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

    public static ChartConfig findChartConfigByType(String chartType, String yamlFilePath) throws IOException {
        File yamlFile = new File(yamlFilePath);

        if (!yamlFile.exists() || !yamlFile.isFile()) {
            throw new IllegalArgumentException("Invalid file path: " + yamlFilePath);
        }

        ChartConfig chartConfig = yamlMapper.readValue(yamlFile, ChartConfig.class);

        if (!chartType.equalsIgnoreCase(chartConfig.getType())) {
            throw new IllegalArgumentException("Chart type mismatch: " + chartType + " vs " + chartConfig.getType());
        }

        return chartConfig;
    }
}
