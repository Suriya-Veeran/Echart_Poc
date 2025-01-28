package report.implementations.header_impl;

import lombok.Getter;
import lombok.Setter;
import report.beans.header.HeaderAdditionalInputBean;
import report.beans.header.HeaderTitleInputBean;
import report.beans.header.LogoInputBean;
import report.interfaces.header.HeaderInput;

@Getter
@Setter
public class HeaderInputImpl implements HeaderInput {

  private HeaderTitleInputBean headerTitleInputBean;
  private LogoInputBean logoInputBean;
  private HeaderAdditionalInputBean headerAdditionalInputBean;

  @Override
  public void setHeaderTitleInputBean(HeaderTitleInputBean headerTitleInputBean) {
    this.headerTitleInputBean = headerTitleInputBean;
  }

  @Override
  public void setLogoInputBean(LogoInputBean logoInputBean) {
    this.logoInputBean = logoInputBean;
  }

  @Override
  public void setHeaderAdditionalInputBean(HeaderAdditionalInputBean headerAdditionalInputBean) {
    this.headerAdditionalInputBean = headerAdditionalInputBean;
  }
}
