package com.example.ipademo.repository;

import com.example.ipademo.IpademoApplicationTests;
import com.example.ipademo.model.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@WebAppConfiguration
public class PersonRepositoryTest extends IpademoApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void create() {
        Person p = new Person();

        p.setName("lee");
        p.setEmail("lee@nate.com");
        p.setCreateAt(LocalDateTime.now());
        p.setCreateBy("Admin");
        p.setCreateBy("Test");

        System.out.println(p.toString());
        personRepository.save(p);

    }
    //디버깅 (어디에.. 문제가 발생했는지 찾는 것)
    //단위테스트 (내 코드에 대한 확신이 있을때 이걸 증명하기 위해서)
    @Test
    public void read() {
        Optional<Person> person = personRepository.findById(1);// 첫번째꺼를 찾아온다

        //Person p;
        //ifPresent 존재하는지 확인
      /*  person.ifPresent( p ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getEmail());
        });//true 여야지만 동작*/

        Assertions.assertTrue((person.isPresent()));// assertTrue: ture라는걸 확신을 갖고 찾는다./ assertFalse: false라는걸 확신을 갖고 찾는다.

        person.ifPresent( p ->{
            System.out.println(p);
        });// 첫번째에 존재한다면 찍어준다.

        System.out.println("종료~!");
    }

    @Test
    //@Transactional //모든 작업을 원상태로 돌린다.
    public void update(){
        Optional<Person> person = personRepository.findById(2);
        person.ifPresent( p ->{
            p.setName("kkkkkkkk");
            personRepository.save(p);
        });
    }


    @Test
    //@Transactional
    public void delete(){
        Optional<Person> person = personRepository.findById(2);
        person.ifPresent( p ->{
            personRepository.delete(p);
        });
    }

}
