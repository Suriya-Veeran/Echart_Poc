package report.beans.header;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeaderInputBean {

  @Builder.Default
  private HeaderTitleInputBean headerTitleInputBean  = new HeaderTitleInputBean();

  @Builder.Default
  private LogoInputBean logoInputBean  = new LogoInputBean();

  @Builder.Default
  private HeaderAdditionalInputBean headerAdditionalInputBean = new HeaderAdditionalInputBean();
}
