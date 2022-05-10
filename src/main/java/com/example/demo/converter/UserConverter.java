package com.example.demo.converter;
import com.example.demo.dto.MyUserDto;
import com.example.demo.model.MyUser;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    private final DepositConverter depositConverter;

    public UserConverter(DepositConverter depositConverter) {
        this.depositConverter = depositConverter;
    }

    public MyUserDto from(MyUser myUser){
        MyUserDto myUserDto = new MyUserDto();

        myUserDto.setDeposit(depositConverter.from(myUser.getDeposit()));
        myUserDto.setUsername(myUser.getUsername());
        myUserDto.setRoles(myUser.getRoles());
        myUserDto.setPassword(myUser.getPassword());

        return myUserDto;
    }

    public MyUser to(MyUserDto myUserDto){
        MyUser myUser = new MyUser();

        myUser.setDeposit(depositConverter.to(myUserDto.getDeposit()));
        myUser.setUsername(myUserDto.getUsername());
        myUser.setRoles(myUserDto.getRoles());
        myUser.setPassword(myUserDto.getPassword());

        return myUser;
    }
}
