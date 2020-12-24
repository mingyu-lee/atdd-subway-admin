package nextstep.subway.station.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nextstep.subway.common.exception.NotFoundException;
import nextstep.subway.station.domain.Station;

@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StationResponse {
	private Long id;
	private String name;
	private int nextDistance;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;

	public static StationResponse of(Station station) {
		if (station == null) {
			throw new NotFoundException("역 정보를 찾을 수 없습니다.");
		}
		return new StationResponse(
			station.getId(),
			station.getName(),
			station.getNextDistance(),
			station.getCreatedDate(),
			station.getModifiedDate());
	}

}