package com.bmarques.cardinsurance.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Abstract interface for pagination information.
 *
 * @author Tiago Marques
 */
@Getter
@Setter
public class PageFilter {

  private static final int DEFAULT_PAGE_INDEX = 1;
  private static final int DEFAULT_ITEMS_PER_PAGE = 50;
  private static final String DEFAULT_SEARCH = "";
  public static final String REGEX_ORDER_BY = "^(\\w+(\\+|\\s)(asc|desc)(,\\w+(\\+|\\s)(asc|desc))*)*$";

  /**
   * Define how much items will be retrieved in each page.
   * Min value = 1
   * Default value = 50
   */
  @Min(value = 1, message = "Items per page must be greater than zero.")
  private Integer itemsPerPage;
  /**
   * Define what page will be retrieved, first page is 1.
   * Min value = 1
   * Default value = 1
   */
  @Min(value = 1, message = "Page index must be greater than zero.")
  private Integer pageIndex;

  /**
   * Define what the oder will be applied to sort the consult,
   * should be used with the following format
   * field1+asc,field2+desc...
   * Default value = Unsorted
   */
  @Pattern(
      regexp = REGEX_ORDER_BY,
      message = "Order by do not respect the pattern field1+asc,field2+desc...")
  private String orderBy;

  /**
   * Will be used to filter search by textual mode.
   * Default value = ""
   */
  private String search;

  public PageFilter() {
    itemsPerPage = DEFAULT_ITEMS_PER_PAGE;
    pageIndex = DEFAULT_PAGE_INDEX;
    search = DEFAULT_SEARCH;
  }

  public Pageable toPageable() {
    return Optional.ofNullable(orderBy)
        .map(this::buildSort)
        .map(sort -> PageRequest.of(pageIndex - 1, itemsPerPage, sort))
        .orElseGet(() -> PageRequest.of(pageIndex - 1, itemsPerPage));
  }

  private Sort buildSort(String sort) {
    if (sort == null || sort.trim().length() == 0) {
      return Sort.unsorted();
    }
    List<Order> orderList =
        Arrays.stream(sort.split(","))
            .map(
                element -> {
                  String[] split = element.split("\\s|\\+");
                  return new Order(Direction.valueOf(split[1].toUpperCase()), split[0]);
                })
            .collect(Collectors.toList());

    return Sort.by(orderList);
  }
}
