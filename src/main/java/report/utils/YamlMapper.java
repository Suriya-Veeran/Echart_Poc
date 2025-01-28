package report.utils;

import java.io.FileReader;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;
import report.beans.header.HeaderInputBean;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class YamlMapper {
  public static HeaderInputBean parseYaml(String yamlFilePath) throws IOException {
    Yaml yaml = new Yaml();
    FileReader fileReader = new FileReader(yamlFilePath);
    return yaml.loadAs(fileReader, HeaderInputBean.class);
  }
}
