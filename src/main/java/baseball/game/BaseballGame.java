package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGame {

    private static final int NUM_DIGIT = 3;

    private static final String OPENING_LINE = "숫자 야구 게임을 시작합니다.";
    private static final String QUESTION_LINE = "숫자를 입력해주세요 : ";
    private static final String CLOSING_LINE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String REPLAY_LINE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private List<Integer> computer;
    private List<Integer> user;

    public void run() {

    }

    public void createComputerNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public int countStrike() {
        int cnt = 0;
        for (int i = 0; i < NUM_DIGIT; i++) {
            if (computer.get(i).equals(user.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countBall() {
        int cnt = 0;
        for (int i = 0; i < NUM_DIGIT; i++) {
            int number = user.get(i);
            if (!computer.get(i).equals(number) && computer.contains(number)) {
                cnt++;
            }
        }
        return cnt;
    }

    public void printHint(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (ball > 0) {
            System.out.print(ball + BALL);
        }
        if (strike > 0) {
            System.out.print(strike + STRIKE);
        }
        System.out.println();
    }

    protected void setComputer(String computer) {
        this.computer = Arrays.stream(computer.split(""))
                .map(Integer::valueOf)
                .toList();
    }

    protected void setUser(String user) {
        this.user = Arrays.stream(user.split(""))
                .map(Integer::valueOf)
                .toList();
    }
}
