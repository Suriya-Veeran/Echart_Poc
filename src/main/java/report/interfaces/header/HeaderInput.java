package report.interfaces.header;

import report.beans.header.HeaderAdditionalInputBean;
import report.beans.header.HeaderTitleInputBean;
import report.beans.header.LogoInputBean;

public interface HeaderInput {
  void setHeaderTitleInputBean(HeaderTitleInputBean headerTitleInputBean);

  void setLogoInputBean(LogoInputBean logoInputBean);

  void setHeaderAdditionalInputBean(HeaderAdditionalInputBean headerAdditionalInputBean);
}
