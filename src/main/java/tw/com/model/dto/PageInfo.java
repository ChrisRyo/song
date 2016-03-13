package tw.com.model.dto;

import lombok.Data;

@Data
public class PageInfo {

  private int pageIndex;

  private int pageSize;

  private String sort;
}
