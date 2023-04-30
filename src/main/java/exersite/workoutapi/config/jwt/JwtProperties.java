package exersite.workoutapi.config.jwt;

public interface JwtProperties {

    // 인터페이스는 객체를 생성하지 않기 때문에 객체 멤버 변수가 없다. 항상 클래스 멤버 변수만 선언 가능하다
    // 멤버 변수는 항상 public static final이다
    // public static final 키워드는 생략 가능하다
    String SECRET = "London is Blue";
    int EXPIRATION_TIME = 864000000; // 10일
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
