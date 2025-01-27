package apache_echarts.beans.chart;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LabelInfoBean {
  private boolean show; // Whether the label is displayed
  private String position; // Position of the label (e.g., inside, outside)
  private int fontSize; // Font size of the label
  private String formatter; // Text format for the label (e.g., "{b}: {c} ({d}%)")

  // New Properties
  private String color; // Color of the label text
  private String fontWeight; // Font weight (e.g., normal, bold)
  private String fontFamily; // Font family (e.g., Arial, Verdana)
  private String align; // Horizontal text alignment (e.g., left, center, right)
  private String verticalAlign; // Vertical text alignment (e.g., top, middle, bottom)
  private String backgroundColor; // Background color of the label
  private List<Integer> padding; // Padding around the label text
  private String shadowColor; // Shadow color for the label
  private int shadowBlur; // Shadow blur for the label
  private int shadowOffsetX; // Horizontal shadow offset
  private int shadowOffsetY; // Vertical shadow offset
}
