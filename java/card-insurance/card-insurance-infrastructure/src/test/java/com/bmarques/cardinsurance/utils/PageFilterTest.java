package com.bmarques.cardinsurance.utils;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PageFilterTest {

  @Test
  void shouldMapToPageableWithDefaultValues() {
    PageFilter pageFilter = new PageFilter();
    Pageable result = pageFilter.toPageable();
    assertAll(
        () -> assertEquals(50, result.getPageSize()),
        () -> assertEquals(0, result.getPageNumber()),
        () -> assertEquals(Sort.unsorted(), result.getSort()),
        () -> assertEquals("", pageFilter.getSearch()));
  }

  @Test
  void shouldMapToPageableWithCustomValues() {
    PageFilter pageFilter = new PageFilter();
    pageFilter.setItemsPerPage(13);
    pageFilter.setPageIndex(9);
    pageFilter.setSearch("12346");
    pageFilter.setOrderBy("code desc,name asc");
    Pageable result = pageFilter.toPageable();

    List<Order> expectedOrders =
        Arrays.asList(new Order(Direction.DESC, "code"), new Order(Direction.ASC, "name"));

    assertAll(
        () -> assertEquals(13, result.getPageSize()),
        () -> assertEquals(8, result.getPageNumber()),
        () -> assertEquals(Sort.by(expectedOrders), result.getSort()),
        () -> assertEquals("12346", pageFilter.getSearch()));
  }

  @Test
  void shouldMapToPageableWithOrderByNull() {
    PageFilter pageFilter = new PageFilter();
    pageFilter.setItemsPerPage(13);
    pageFilter.setPageIndex(9);
    pageFilter.setSearch("12346");
    pageFilter.setOrderBy(null);
    Pageable result = pageFilter.toPageable();

    assertAll(
        () -> assertEquals(13, result.getPageSize()),
        () -> assertEquals(8, result.getPageNumber()),
        () -> assertEquals(Sort.unsorted(), result.getSort()),
        () -> assertEquals("12346", pageFilter.getSearch()));
  }

  @Test
  void shouldMapToPageableWithNoOrderBy() {
    PageFilter pageFilter = new PageFilter();
    pageFilter.setItemsPerPage(13);
    pageFilter.setPageIndex(9);
    pageFilter.setSearch("12346");
    pageFilter.setOrderBy("");
    Pageable result = pageFilter.toPageable();

    assertAll(
        () -> assertEquals(13, result.getPageSize()),
        () -> assertEquals(8, result.getPageNumber()),
        () -> assertEquals(Sort.unsorted(), result.getSort()),
        () -> assertEquals("12346", pageFilter.getSearch()));
  }

  @Test
  void shouldMapToPageableWithWhiteSpaceOrderBy() {
    PageFilter pageFilter = new PageFilter();
    pageFilter.setItemsPerPage(13);
    pageFilter.setPageIndex(9);
    pageFilter.setSearch("12346");
    pageFilter.setOrderBy("      ");
    Pageable result = pageFilter.toPageable();

    assertAll(
        () -> assertEquals(13, result.getPageSize()),
        () -> assertEquals(8, result.getPageNumber()),
        () -> assertEquals(Sort.unsorted(), result.getSort()),
        () -> assertEquals("12346", pageFilter.getSearch()));
  }


  @Test
  void shouldReturnTrueForValidOrderBy() {
    List<String> validOrderBy =
        Arrays.asList(
            "code+asc",
            "code asc",
            "code+desc",
            "code desc",
            "code+asc,name+desc",
            "code asc,name desc",
            "code+asc,name desc",
            "code asc,name+desc");
    assertTrue(
        validOrderBy.stream().allMatch(orderBy -> orderBy.matches(PageFilter.REGEX_ORDER_BY)));
  }

  @Test
  void shouldReturnFalseForInvalidOrderBy() {
    List<String> invalidOrderBy =
        Arrays.asList(
            "code+asc,",
            "code asc,",
            "code+desc,",
            "code desc,",
            "code",
            "code+xxx",
            "code xxx",
            "code asc,name desc,",
            "code+asc,name+desc,",
            "code+asc,name desc,");
    assertTrue(
        invalidOrderBy.stream().noneMatch(orderBy -> orderBy.matches(PageFilter.REGEX_ORDER_BY)));
  }
}
