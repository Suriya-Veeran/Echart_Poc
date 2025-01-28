package report.beans.header;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeaderInputBean {

  private HeaderTitleInputBean headerTitleInputBean;

  private LogoInputBean logoInputBean;

  private HeaderAdditionalInputBean headerAdditionalInputBean;
}
