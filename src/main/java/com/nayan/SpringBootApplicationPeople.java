package com.nayan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class SpringBootApplicationPeople {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationPeople.class, args);
    }


    public static class Person{
        public Person(Integer id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id && age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, age);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @NotNull
        private Integer id;
        private String name;
        @Max(80)
        private int age;
    }

    static  List<Person> peopleList=Arrays.asList(new Person(1,"Nayan",23), new Person(2,"Muna",22));

    @GetMapping("people")
    public List<Person> getAll(){
        return peopleList;
    }


    @GetMapping("people/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {
        for (Person person : peopleList) {
            if(person.getId() == id){
                return person;
            }
        }return null;

//        return peopleList.stream().filter(e-> e.getId()==id).findFirst().orElse(null);
    }

    //The path can be the same because different http request i.e GetMapping != PostMapping
    @PostMapping(path="people")
    void addPerson( @RequestBody @Valid Person person){ //@RequestBody is needed to take in person from the body + Look into @Valid
        System.out.println(person);
    }

}
