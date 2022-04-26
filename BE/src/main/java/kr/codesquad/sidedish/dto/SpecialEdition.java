package kr.codesquad.sidedish.dto;

import java.util.List;
import kr.codesquad.sidedish.domain.Event;

public class SpecialEdition {

    private final String name = "짱민BEST 추천 메뉴";
    private List<EventResponse> eventDishes;

    public SpecialEdition(List<EventResponse> eventDishes) {
        this.eventDishes = eventDishes;
    }

    public String getName() {
        return name;
    }

    public List<EventResponse> getEventDishes() {
        return eventDishes;
    }
}
