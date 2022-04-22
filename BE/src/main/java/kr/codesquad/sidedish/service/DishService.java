package kr.codesquad.sidedish.service;

import java.util.List;
import java.util.stream.Collectors;
import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.dto.DishDetailResponse;
import kr.codesquad.sidedish.dto.DishSimpleResponse;
import kr.codesquad.sidedish.repository.JdbcDishRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DishService {

    private final JdbcDishRepository jdbcDishRepository;
    private final int PAGE_SIZE = 4;

    public DishService(JdbcDishRepository jdbcDishRepository) {
        this.jdbcDishRepository = jdbcDishRepository;
    }

    public DishDetailResponse findOne(Long id) {
        Dish dish = jdbcDishRepository.findById(id).orElseThrow();

        return DishDetailResponse.from(dish);
    }

    public List<DishSimpleResponse> getNextDishes(Long lastDishId, Long categoryId) {
        int currentPage = (int) (lastDishId / PAGE_SIZE);
        PageRequest p = PageRequest.of(currentPage, PAGE_SIZE);

        return jdbcDishRepository.findDishesByCategoryId(categoryId, p)
            .stream().map(DishSimpleResponse::of)
            .collect(Collectors.toList());
    }

}
