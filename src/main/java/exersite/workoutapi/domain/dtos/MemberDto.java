package exersite.workoutapi.domain.dtos;

import exersite.workoutapi.domain.member.Member;
import lombok.Data;

@Data
public class MemberDto {

    private Long id;
    private String email;
    private String name;
    private String nickname;
    private String city;
    private String street;
    private String zipcode;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.nickname = member.getNickname();
        this.city = member.getAddress().getCity();
        this.street = member.getAddress().getStreet();
        this.zipcode = member.getAddress().getZipcode();
    }
}
