package com.gwnu.admin.Gangneungwalk.controller;


import com.gwnu.admin.Gangneungwalk.dto.GnResponseDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//JSON을 반환하는 Controller
public class GnController {

    @GetMapping("/user/join")
    public String join(Model model){
        model.addAttribute("data","test join");
        return "join";
    }


    @GetMapping("/user/login")
    public String login(Model model){
        model.addAttribute("data","test login");
        return "login";
    }

    @GetMapping("/user/dto")
    /** RequestParam 외부 API로 넘긴 파라이터를 가져오는 어노테이션
     * @RequestParam("name") 외부에서 받은거 String name 에 저장
     */
    public GnResponseDto gnResponseDto(@RequestParam("userName") String userName,
                                       @RequestParam("userEmail") String userEmail,
                                       @RequestParam("amount") int amount) {

        return new GnResponseDto(userName, userEmail, amount);
    }



}
