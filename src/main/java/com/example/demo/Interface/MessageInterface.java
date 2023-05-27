package com.example.demo.Interface;


import com.example.demo.Modelo.Messages;
import org.aspectj.bridge.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageInterface extends CrudRepository<Messages, Integer> {
}
