package com.es.api.controller;

import com.es.api.config.security.JwtTokenProvider;
import com.es.api.config.security.UserPrincipal;
import com.es.api.entity.User;
import com.es.api.parameters.UserParameter;
import com.es.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "회원")
@RequestMapping(value = "/api")
public class UserController {
//    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;


    @Autowired
    public UserController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @ApiOperation(value = "회원가입", notes = "회원가입", tags = "회원")
    @PostMapping(value = "/signup")
    public User create(@RequestBody  @ApiParam UserParameter userParameter) {
        return userService.join(userParameter);
    }


    @ApiOperation(value = "로그인", notes = "로그인", tags = "회원")
    @PostMapping(value = "/signin")
    public String login(@RequestBody UserParameter userParameter) throws Exception{
        User user = userService.login(userParameter);
        return jwtTokenProvider.createToken(user.getId());
    }


    @ApiOperation(value = "로그인회원 정보 조회", notes = "로그인회원 정보 조회", tags = "회원")
    @GetMapping(value = "/me")
    public User getMe() {
        // SecurityContext에서 인증받은 회원의 정보를 얻어온다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        long id = ((UserPrincipal) authentication.getPrincipal()).getID();
        return userService.getId(id);
    }
}
