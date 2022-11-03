package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BallTest {

	List<String> range = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
	@Test
	void 랜덤_공번호_생성() {
		Ball ball = Ball.getInstance();
		assertTrue(range.contains(ball.createRandomBall()));
	}
}